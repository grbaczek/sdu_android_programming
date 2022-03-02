/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sdu.android.programming.com

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

class HeadlinesFragment : ListFragment() {

    private var mCallback: OnHeadlineSelectedListener? = null

    // The container Activity must implement this interface so the frag can deliver messages
    interface OnHeadlineSelectedListener {
        /** Called by HeadlinesFragment when a list item is selected  */
        fun onArticleSelected(position: Int)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // We need to use a different list item layout for devices older than Honeycomb
        val layout = android.R.layout.simple_list_item_activated_1

        // Create an array adapter for the list view, using the Ipsum headlines array
        listAdapter = ArrayAdapter(requireContext(), layout, Ipsum.Headlines)
    }

    override fun onStart() {
        super.onStart()

        // When in two-pane layout, set the listview to highlight the selected list item
        // (We do this during onStart because at the point the listview is available.)
        if (fragmentManager?.findFragmentById(R.id.article_fragment) != null) {
            listView.choiceMode = ListView.CHOICE_MODE_SINGLE
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        mCallback = try {
            activity as OnHeadlineSelectedListener?
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString()
                        + " must implement OnHeadlineSelectedListener"
            )
        }
    }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        // Notify the parent activity of selected item
        mCallback?.onArticleSelected(position)

        // Set the item as checked to be highlighted when in two-pane layout
        listView.setItemChecked(position, true)
    }
}