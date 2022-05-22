package com.example.senators.senatordetails

import android.Manifest.permission.CALL_PHONE
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.senators.MainActivity
import com.example.senators.R
import com.example.senators.databinding.FragmentSenatorDetailsBinding


class SenatorDetailsFragment : Fragment() {

    var binding: FragmentSenatorDetailsBinding? = null
    private val viewModel: SenatorDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSenatorDetailsBinding.inflate(inflater, container, false)
        binding?.lifecycleOwner = this
        binding?.viewModel = viewModel
        (activity as MainActivity).binding?.toolbar?.setNavigationIcon(R.drawable.ic_baseline_arrow_back_ios_24)


        val senator = SenatorDetailsFragmentArgs.fromBundle(requireArguments()).senator
        viewModel.setSenator(senator)


        binding?.call?.setOnClickListener {
            senator.contact.phone_number?.let {
                checkCallPermission(it)
            }
        }

        binding?.sendEmail?.setOnClickListener {
            senator.contact.email?.let {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:$it")
                }
                startActivity(Intent.createChooser(emailIntent, "Send Email"))
            }
        }

        setHasOptionsMenu(true)

        return binding!!.root
    }

    private fun checkCallPermission(phone: String) {
        if (checkSelfPermission(requireContext(), CALL_PHONE) != PackageManager.PERMISSION_GRANTED
        ) {
            activity?.requestPermissions(arrayOf(CALL_PHONE), 1)
        } else {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:$phone")
            startActivity(intent)
        }
    }
}