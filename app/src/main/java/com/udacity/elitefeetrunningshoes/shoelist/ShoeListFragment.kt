package com.udacity.elitefeetrunningshoes.shoelist

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.udacity.elitefeetrunningshoes.R
import com.udacity.elitefeetrunningshoes.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )
        return binding.root
    }
}