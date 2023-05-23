package com.mbahjephthah.examgpt.ui.navigation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mbahjephthah.examgpt.R
import java.util.Locale


@Composable
fun NavDrawer(
    modifier: Modifier = Modifier,
    drawerState: DrawerState,
    onNavigationSelected:(destination: Destination)-> Unit,
    onLogout:()->Unit,
    content: @Composable ()-> Unit
) {

    ModalNavigationDrawer(
        modifier = modifier,
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                content = {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = stringResource(id = R.string.label_name),
                        style = TextStyle(
                            fontSize = 20.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = stringResource(id = R.string.label_email),
                        style = TextStyle(
                            fontSize = 16.sp
                        )
                    )

                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    )

                    DrawerItem(
                        modifier = Modifier
                            .fillMaxWidth(),
                        label = Destination.Upgrade.path,
                        selected = true,
                        onClick = {
                            onNavigationSelected(Destination.Upgrade)
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    DrawerItem(
                        modifier = Modifier
                            .fillMaxWidth(),
                        label = Destination.Settings.path,
                        selected = false,
                        onClick = {
                            onNavigationSelected(Destination.Settings)
                        }
                    )

                    Spacer(modifier = Modifier.weight(1f))
                    DrawerItem(
                        modifier = Modifier
                            .fillMaxWidth(),
                        label = stringResource(id = R.string._log_out),
                        selected = false,
                    ) {
                        onLogout()

                    }
                    Spacer(modifier = Modifier.height(8.dp))


                }
            )



        },
        content =  content
    )


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerItem(
    modifier: Modifier = Modifier,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    NavigationDrawerItem(
        modifier = modifier,
        label = {
            Text(
                modifier = Modifier
                    .padding(16.dp),
                text = label.replaceFirstChar {
                    it.titlecase(Locale.getDefault())
                },

                )
        },
        selected = selected,
        onClick = { onClick() }
    )

}