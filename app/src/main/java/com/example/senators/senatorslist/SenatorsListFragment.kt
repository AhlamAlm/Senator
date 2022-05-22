package com.example.senators.senatorslist

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.senators.R
import com.example.senators.databinding.FragmentSenatorsListBinding

class SenatorsListFragment: Fragment() {

    var binding: FragmentSenatorsListBinding? = null
    private val viewModel: SenatorsListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSenatorsListBinding.inflate(inflater, container, false)
        binding?.lifecycleOwner = this
        binding?.viewModel = viewModel

        val jsonFile = requireActivity().resources?.openRawResource(R.raw.contacts)?.bufferedReader().use { it?.readText() }
        viewModel.getSenatorsList(jsonFile)


        binding?.senatorsRv?.adapter = SenatorsListAdapter(SenatorsListAdapter.SenatorListener {
            findNavController().navigate(SenatorsListFragmentDirections.actionSenatorsListFragmentToSenatorDetailsFragment(it))
        })

        setHasOptionsMenu(true)

        return binding!!.root
    }


}