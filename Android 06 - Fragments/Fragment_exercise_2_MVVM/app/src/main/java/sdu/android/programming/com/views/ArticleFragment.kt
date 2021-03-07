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

        // Inflate the layout for this fragment
        tvArticle = inflater.inflate(R.layout.article_view, container, false) as TextView
        return tvArticle
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        articleViewModel.getSelectedArticle().observe(viewLifecycleOwner, {
            tvArticle.text = it.second.body
            mCurrentPosition = it.first
        })
    }

}
