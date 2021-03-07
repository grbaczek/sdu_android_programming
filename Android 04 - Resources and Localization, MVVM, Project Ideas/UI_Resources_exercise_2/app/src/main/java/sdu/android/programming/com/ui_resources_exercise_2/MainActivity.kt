package sdu.android.programming.com.ui_resources_exercise_2

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {

    private val images = ArrayList<Bitmap>()
    private lateinit var mImageView: ImageView
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Manual loading of images
        val options = BitmapFactory.Options()
        options.inScaled = true
        images.add(BitmapFactory.decodeResource(resources, R.drawable.pexels_photo))
        images.add(BitmapFactory.decodeResource(resources, R.drawable.pexels_photo_62592))
        images.add(BitmapFactory.decodeResource(resources, R.drawable.pexels_photo_210723))
        images.add(BitmapFactory.decodeResource(resources, R.drawable.pexels_photo_462353))
        mImageView = findViewById(R.id.image_view)
        setImage()
    }

    fun setImage() {
        mImageView.setImageBitmap(images[index])
    }

    fun nextClick(view: View?) {
        if (index >= images.size - 1) {
            index = 0
        } else {
            index++
        }
        setImage()
    }

    fun previousClick(view: View?) {
        if (index <= 0) {
            index = images.size - 1
        } else {
            index--
        }
        setImage()
    }
}