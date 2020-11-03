/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skydoves.androidbottombardemo.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.skydoves.androidbottombardemo.R
import kotlinx.android.synthetic.main.item_poster_line.view.*

class PosterLineAdapter : RecyclerView.Adapter<PosterLineAdapter.PosterViewHolder>() {

  private val items = mutableListOf<Poster>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    return PosterViewHolder(inflater.inflate(R.layout.item_poster_line, parent, false))
  }

  override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
    val item = items[position]
    holder.itemView.run {
      Glide.with(context)
        .load(item.poster)
        .into(item_poster_post)
      item_poster_title.text = item.name
      item_poster_running_time.text = item.playtime
    }
  }

  fun addPosterList(list: List<Poster>) {
    items.clear()
    items.addAll(list)
    notifyDataSetChanged()
  }

  override fun getItemCount() = items.size

  class PosterViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
