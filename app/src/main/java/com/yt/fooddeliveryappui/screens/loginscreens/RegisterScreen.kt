package com.yt.fooddeliveryappui.screens.loginscreens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import com.yt.fooddeliveryappui.R
import com.yt.fooddeliveryappui.commonui.*
import com.yt.fooddeliveryappui.screens.activities.HomeActivity
import com.yt.fooddeliveryappui.ui.theme.gray
import com.yt.fooddeliveryappui.ui.theme.lightGray
import com.yt.fooddeliveryappui.ui.theme.orange
import com.yt.fooddeliveryappui.utils.launchActivity
import com.yt.fooddeliveryappui.viewmodels.AuthState
import com.yt.fooddeliveryappui.viewmodels.AuthViewModel

object RegisterScreen : Screen {

    @Composable
    override fun Content() {

        val context = LocalContext.current
        var track1 by remember { mutableStateOf(true) }
        var track2 by remember { mutableStateOf(false) }
        var emailLogin by remember { mutableStateOf("") }
        var passwordLogin by remember { mutableStateOf("") }

        var emailReg by remember { mutableStateOf("") }
        var passwordReg by remember { mutableStateOf("") }

        val authViewModel: AuthViewModel = viewModel()
        val authState by authViewModel.authState.observeAsState()


        LaunchedEffect(authState) {
            when(authState){
                is AuthState.Authtenticated -> context.launchActivity<HomeActivity> {}
                is AuthState.Error -> Toast.makeText(context, (authState as AuthState.Error).message,Toast.LENGTH_SHORT).show()
                else -> Unit
            }
        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(lightGray)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .weight(0.4f),
                elevation = 3.dp,
                shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)
            ) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box {}

                    Icon(
                        painter = painterResource(id = R.drawable.app_icon2),
                        contentDescription = "",
                        modifier = Modifier.size(150.dp),
                        tint = Color.Unspecified
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column(
                            modifier = Modifier.width(90.dp)
                        ) {
                            Text18_600(text = "Login", color = Color.Black, modifier = Modifier
                                .NoRippleEffect {
                                    if (track1) {
                                    } else {
                                        track1 = true
                                        track2 = false
                                    }
                                }
                                .align(CenterHorizontally))
                            if (track1)
                                CommonLine(
                                    height = 3.dp,
                                    width = 87.dp,
                                    modifier = Modifier.padding(top = 5.dp)
                                )
                        }

                        Column(
                            modifier = Modifier.width(90.dp)
                        ) {
                            Text18_600(text = "Rejestracja", color = Color.Black, modifier = Modifier
                                .NoRippleEffect {
                                    if (track2) {
                                    } else {
                                        track1 = false
                                        track2 = true
                                    }
                                }
                                .align(CenterHorizontally))
                            if (track2)
                                CommonLine(
                                    height = 3.dp,
                                    width = 87.dp,
                                    modifier = Modifier.padding(top = 5.dp)
                                )
                        }
                    }


                }

            }

            if (track1)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp)
                        .weight(0.6f),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    EmailAndPassword(
                        email = emailLogin,
                        onEmailChange = { emailLogin = it },
                        password = passwordLogin,
                        onPasswordChange = { passwordLogin = it }
                    ) {
                        authViewModel.login(emailLogin, passwordLogin)
                    }
                }

            if (track2)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp)
                        .weight(0.6f),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    EmailAndPassword(
                        email = emailReg,
                        onEmailChange = { emailReg = it },
                        password = passwordReg,
                        onPasswordChange = { passwordReg = it },
                        buttonText = "Rejestracja",
                        isForget = false
                    ) {
                        authViewModel.signup(emailReg, passwordReg)
                    }
                }
        }

    }

    @Composable
    fun EmailAndPassword(
        email: String,
        onEmailChange: (String) -> Unit,
        password: String,
        onPasswordChange: (String) -> Unit,
        isForget: Boolean = true,
        buttonText: String = "Login",
        onclick: () -> Unit
    ) {
        val focusRequester = FocusRequester()

        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ) {
                Text15_600(text = "Email", color = gray)
                CommonTextField(
                    text = email,
                    onTextChange = onEmailChange,
                    modifier = Modifier.focusRequester(focusRequester)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ) {
                Text15_600(text = "Hasło", color = gray)
                CommonTextField(
                    text = password,
                    onTextChange = onPasswordChange,
                    keyboardType = KeyboardType.Password
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            if (isForget)
                Text17_600(text = "Zapomniałeś hasła?", color = orange)
        }

        CommonButton(
            text = buttonText,
            backgroundColor = orange,
            foregroundColor = Color.White
        ) {
            onclick()
        }
    }

}