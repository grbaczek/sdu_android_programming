package sdu.android.programming.com.viewmodels

import androidx.lifecycle.ViewModel
import sdu.android.programming.com.models.Article
import sdu.android.programming.com.models.ArticleManager


class ArticleViewModel: ViewModel() {

    lateinit var articles: ArrayList<Article>
    lateinit var articleHeadLines: Array<String?>
    private val articleManager = ArticleManager()

    init {
        loadArticles()
        loadArticleHeadlines()
    }

    fun getArticles(): List<Article> {
        return articles
    }

    fun loadArticleHeadlines() {
        articleHeadLines = articleManager.getArticleHeadlines()
    }

    private fun loadArticles() {
        articles = articleManager.articles
    }
}
