package unlam.resicapp.presentation.util

import android.widget.ImageView
import com.example.resicappandroid.R
import com.squareup.picasso.Picasso

class ImageTransformation(
    private val imageUrl: String
) {

    fun loadItemSizeImage(view: ImageView) {
        return Picasso
            .get()
            .load(imageUrl)
            .error(R.drawable.ic_launcher_foreground)
            .resize(300, 300)
            .into(view)
    }

}