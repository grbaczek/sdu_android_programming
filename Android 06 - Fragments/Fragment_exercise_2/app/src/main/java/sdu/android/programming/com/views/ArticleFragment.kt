package sdu.android.programming.com.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import sdu.android.programming.com.R
import sdu.android.programming.com.viewmodels.ArticleViewModel

class ArticleFragment : Fragment() {

    private val articleViewModel: ArticleViewModel by activityViewModels()
    private var mCurrentPosition = -1
    private lateinit var tvArticle: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        // If activity recreated (such as from screen rotate), restore
        // the previous article selection set by onSaveInstanceState().
        // This is primarily necessary when in the two-pane layout.
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION)
        }

        // Inflate the layout for this fragment
        tvArticle = inflater.inflate(R.layout.article_view, container, false) as TextView
        return tvArticle
    }

    override fun onStart() {
        super.onStart()

        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.
        val args = arguments
        if (args != null) {
            // Set article based on argument passed in
            updateArticleView(args.getInt(ARG_POSITION))
        } else if (mCurrentPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
            updateArticleView(mCurrentPosition)
        }
    }

    fun updateArticleView(position: Int) {
        tvArticle.text = articleViewModel.getArticles()[position].toString()
        mCurrentPosition = position
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(ARG_POSITION, mCurrentPosition)
    }

    companion object {
        const val ARG_POSITION: String = "position"
    }
}
