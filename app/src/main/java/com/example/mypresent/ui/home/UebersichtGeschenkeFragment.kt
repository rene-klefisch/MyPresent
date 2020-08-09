package com.example.mypresent.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mypresent.GiftObject
import com.example.mypresent.R
import com.example.mypresent.ShoppingListAdapter

class UebersichtGeschenkeFragment : Fragment() {

    private lateinit var uebersichtGeschenkeViewModel: UebersichtGeschenkeViewModel
    private var mListView : ListView? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        uebersichtGeschenkeViewModel =
                ViewModelProviders.of(this).get(UebersichtGeschenkeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_uebersicht_geschenke, container, false)
        mListView = root.findViewById(R.id.listUebersichtGeschenke)
        uebersichtGeschenkeViewModel.text.observe(viewLifecycleOwner, Observer {
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listenEintrag = ArrayList<GiftObject>()
        listenEintrag.add(GiftObject(1, "Taschenlampe", false, "Alternate", "Lampe für's Wandern", 2131165293, "Marius"))
        listenEintrag.add(GiftObject(2, "Reisegutschein", false, "Reisebüro", "Flug auf die Nase", 2131165293, "Mama"))
        listenEintrag.add(GiftObject(3, "Nokia 3310", false, "Telefonshop", "Ein Handy mit Akku", 2131165293, "Karl"))
        listenEintrag.add(GiftObject(4, "Call of Duden 2", false, "Game Shop Müller", "Das Spiel für besondere", 2131165293, "Luisa"))

        mListView?.adapter = context?.let { ShoppingListAdapter(it, listenEintrag) }
        /*context?.getDrawable(R.drawable.ic_shopping_cart)?.let {
            GiftObject(1, "Taschenlampe", false, "Alternate", "Lampe für's Wandern",
                it, "Marius")
        }?.let { listenEintrag.add(it) }
        context?.getDrawable(R.drawable.ic_shopping_cart)?.let {
            GiftObject(2, "Reisegutschein", false, "Reisebüro", "Flug auf die Nase",
                it, "Mama")
        }?.let { listenEintrag.add(it) }
        context?.getDrawable(R.drawable.ic_shopping_cart)?.let {
            GiftObject(3, "Nokia 3310", false, "Telefonshop", "Ein Handy mit Akku",
                it, "Karl")
        }?.let { listenEintrag.add(it) }
        context?.getDrawable(R.drawable.ic_shopping_cart)?.let {
            GiftObject(4, "Call of Duden 2", false, "Game Shop Müller", "Das Spiel für besondere",
                it, "Luisa")
        }?.let { listenEintrag.add(it) }

        mListView?.adapter = context?.let { ShoppingListAdapter(it, listenEintrag) }

         */
    }
}