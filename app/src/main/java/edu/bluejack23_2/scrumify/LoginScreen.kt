package edu.bluejack23_2.scrumify

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.bluejack23_2.scrumify.ui.theme.PrimaryBlack
import edu.bluejack23_2.scrumify.ui.theme.PrimaryWhite
import edu.bluejack23_2.scrumify.ui.theme.ScrumifyTheme
import edu.bluejack23_2.scrumify.ui.theme.SecondaryBlack

@Composable
fun LoginScreen () {
    var email by remember {mutableStateOf("")}
    var password by remember {mutableStateOf("")}

    var annonatedString = buildAnnotatedString {
        append("Didn't have an account? ")
        withStyle(style = SpanStyle(color = PrimaryWhite, textDecoration = TextDecoration.Underline)){
            append("Register")
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryBlack),
        contentAlignment = Alignment.Center
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "SCRUMIFY",
                    style = MaterialTheme.typography.h1.copy(
                        color = PrimaryWhite,
                        letterSpacing = 8.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(60.dp))
            OutlinedTextField(
                value = email,
                onValueChange = {email = it },
                label = { Text("Email", color = PrimaryWhite)},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                textStyle = TextStyle(
                    color = PrimaryWhite,
                    fontSize = 16.sp
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = SecondaryBlack,
                    focusedBorderColor = SecondaryBlack,
                    unfocusedBorderColor = SecondaryBlack,
                    cursorColor = PrimaryWhite,
                    textColor = PrimaryWhite
                )
            )
            Spacer(modifier = Modifier.height(1.dp))
            OutlinedTextField(
                value = password,
                onValueChange = {password = it },
                label = { Text("Password", color = PrimaryWhite)},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                textStyle = TextStyle(
                    color = PrimaryWhite,
                    fontSize = 16.sp
                ),
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = SecondaryBlack,
                    focusedBorderColor = SecondaryBlack,
                    unfocusedBorderColor = SecondaryBlack,
                    cursorColor = PrimaryWhite,
                    textColor = PrimaryWhite
                )
            )
            Spacer(modifier = Modifier.height(60.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
                    ){
                Button(
                    shape = RoundedCornerShape(8.dp),
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .height(52.dp)
                        .border(2.dp, SecondaryBlack, RoundedCornerShape(8.dp)),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = PrimaryBlack,
                        contentColor = PrimaryWhite
                    )
                ) {
                    Text(
                        text = "Sign In",
                        color = PrimaryWhite,
                        style = TextStyle(
                            fontSize = 16.sp
                        )
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                Box (
                    modifier = Modifier
                        .size(52.dp)
                        .background(PrimaryBlack, CircleShape)
                        .border(2.dp, SecondaryBlack, CircleShape)
                        .clickable { },
                    contentAlignment = Alignment.Center
                        ){
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_fingerprint),
                            contentDescription = "Biometric Authentication",
                            tint = PrimaryWhite
                        )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box (
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
                    ){
                ClickableText(
                    text = annonatedString,
                    onClick = { },
                    style = TextStyle(color = PrimaryWhite, fontSize = 16.sp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    ScrumifyTheme {
        LoginScreen()
    }
}