package com.udacity.elitefeetrunningshoes.shoelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.elitefeetrunningshoes.R
import com.udacity.elitefeetrunningshoes.databinding.FragmentShoeListBinding
import com.udacity.elitefeetrunningshoes.databinding.ShoeItemBinding

class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_shoe_list,
                container,
                false,
            )
        val shoeListLayout = binding.shoelistLayout
        viewModel.shoeList.observe(viewLifecycleOwner) { shoes ->
            val sortedShoes = shoes.sortedBy { it.company }
            shoeListLayout.removeAllViews()

            sortedShoes.forEach { shoe ->
                val shoeItemBinding = ShoeItemBinding.inflate(layoutInflater)
                shoeItemBinding.shoe = shoe
                shoeListLayout.addView(shoeItemBinding.root)
            }
        }
        binding.fab.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        return binding.root
    }
}
