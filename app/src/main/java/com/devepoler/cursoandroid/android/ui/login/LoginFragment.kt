package com.devepoler.cursoandroid.android.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.devepoler.cursoandroid.android.core.data.LoginResponse
import com.devepoler.cursoandroid.android.core.data.bo.LoginFormBo
import com.devepoler.cursoandroid.android.core.extension.toast
import com.devepoler.cursoandroid.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private val binding by lazy { FragmentLoginBinding.inflate(layoutInflater) }
    private val viewmodel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btLogin.setOnClickListener {
                when (val response = viewmodel.login(getLoginFormBo())) {
                    is LoginResponse.Error -> root.context.toast(response.msg)
                    is LoginResponse.Success -> navToHomeFragment(response.user.name)
                }
            }

            with(btGuess) {
                setOnClickListener { navToHomeFragment() }
                performClick()
            }
        }
    }

    private fun navToHomeFragment(name : String? = null) {
        val direction = LoginFragmentDirections.actionFirstFragmentToSecondFragment(name)
        findNavController().navigate(direction)
    }

    private fun getLoginFormBo() : LoginFormBo {
        val email = binding.tilEmail.editText?.text.toString()
        val password = binding.tilPassword.editText?.text.toString()
        return LoginFormBo(email, password)
    }
}