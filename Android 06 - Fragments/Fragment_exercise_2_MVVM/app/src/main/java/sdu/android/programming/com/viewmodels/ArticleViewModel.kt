package sdu.android.programming.com.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import sdu.android.programming.com.models.Article
import sdu.android.programming.com.models.ArticleManager


class ArticleViewModel : ViewModel() {

    private lateinit var articles: ArrayList<Article>
    private lateinit var articleHeadLines: Array<String?>
    private var selectedArticle = MutableLiveData<Pair<Int, Article>>()
    private val articleManager = ArticleManager()

    init {
        loadArticles()
        loadArticleHeadlines()
    }

    fun getSelectedArticle(): LiveData<Pair<Int, Article>> {
        return selectedArticle
    }

    fun selectArticleAt(position: Int) {
        selectedArticle.value = Pair(position, articles[position])
    }

    fun getHeadlines(): Array<String?> {
        return articleHeadLines
    }

    private fun loadArticleHeadlines() {
        articleHeadLines = articleManager.getArticleHeadlines()
    }

    private fun loadArticles() {
        articles = articleManager.articles
    }
}
