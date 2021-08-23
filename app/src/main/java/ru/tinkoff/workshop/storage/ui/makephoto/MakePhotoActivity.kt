package ru.tinkoff.workshop.storage.ui.makephoto

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import io.fotoapparat.Fotoapparat
import io.fotoapparat.view.CameraView
import ru.tinkoff.workshop.storage.R
import ru.tinkoff.workshop.storage.ui.preview.PhotoPreviewActivity

class MakePhotoActivity : AppCompatActivity(), MakePhotoView {

    companion object {
        private const val RC_CAMERA_PERMISSION = 1337

        fun intent(context: Context): Intent {
            return Intent(context, MakePhotoActivity::class.java)
        }
    }

    private lateinit var fotoapparat: Fotoapparat
    private lateinit var presenter: MakePhotoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_photo)
        presenter = MakePhotoPresenter(this, lifecycle)
        fotoapparat = Fotoapparat(this, findViewById<CameraView>(R.id.cameraView))
        findViewById<View>(R.id.takePhotoButton).setOnClickListener {
            presenter.saveImage(fotoapparat.takePicture())
        }
        findViewById<View>(R.id.permissionButton).setOnClickListener {
            requestCameraPermission()
        }
    }

    override fun onStart() {
        super.onStart()
        invalidateViewsVisibility()
        if (!hasCameraPermission()) {
            requestCameraPermission()
        } else {
            fotoapparat.start()
        }
    }

    override fun onStop() {
        fotoapparat.stop()
        super.onStop()
    }

    override fun navigateToPhotoPreview(uri: Uri) {
        startActivity(PhotoPreviewActivity.intent(this, uri))
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == RC_CAMERA_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                fotoapparat.start()
            }
        }
        invalidateViewsVisibility()
    }

    private fun invalidateViewsVisibility() {
        val hasPermission = hasCameraPermission()
        findViewById<View>(R.id.cameraViews).isVisible = hasPermission
        findViewById<View>(R.id.permissionViews).isVisible = !hasPermission
    }

    private fun hasCameraPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this, Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestCameraPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.CAMERA),
            RC_CAMERA_PERMISSION
        )
    }
}