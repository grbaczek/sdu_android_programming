package com.programming.android.sdu.contentproviderexercise

import android.net.Uri

interface IContactContentProvider {

    fun getDisplayName(): String

    fun getID(): String

    fun getLookupKey(): String

    fun getContentURI(): Uri

}