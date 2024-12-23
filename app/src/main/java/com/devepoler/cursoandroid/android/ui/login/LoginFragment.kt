package com.devepoler.cursoandroid.android.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.devepoler.cursoandroid.R
import com.devepoler.cursoandroid.android.core.data.LoginResponse
import com.devepoler.cursoandroid.android.core.data.bo.LoginFormBo
import com.devepoler.cursoandroid.android.core.extension.toast
import com.devepoler.cursoandroid.android.ui.main.MainViewModel
import com.devepoler.cursoandroid.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private val binding by lazy { FragmentLoginBinding.inflate(layoutInflater) }
    private val viewmodel by viewModels<LoginViewModel>()
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            tilEmail.editText?.setText(R.string.email_helper)
            tilPassword.editText?.setText(R.string.password_helper)

            btLogin.setOnClickListener {
                when (val response = viewmodel.login(getLoginFormBo())) {
                    is LoginResponse.Error -> root.context.toast(response.msg)
                    is LoginResponse.Success -> {
                        mainViewModel.setUser(response.user)
                        navToHomeFragment()
                    }
                }
            }

            btGuess.setOnClickListener {
                mainViewModel.setUser()
                navToHomeFragment()
            }

            btLogin.performClick()
        }
    }

    private fun navToHomeFragment() {
        val direction = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
        findNavController().navigate(direction)
    }

    private fun getLoginFormBo() : LoginFormBo {
        val email = binding.tilEmail.editText?.text.toString()
        val password = binding.tilPassword.editText?.text.toString()
        return LoginFormBo(email, password)
    }
}