package com.mbahjephthah.examgpt.features.settings_dialog.presentation

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.core.content.ContextCompat
import com.mbahjephthah.examgpt.R
import com.mbahjephthah.examgpt.features.settings_dialog.domain.model.DarkThemeConfig
import com.mbahjephthah.examgpt.features.settings_dialog.domain.model.ThemeBrand
import com.mbahjephthah.examgpt.ui.theme.ExamGptTheme
import com.mbahjephthah.examgpt.ui.theme.supportsDynamicTheming


@Composable
fun SettingsDialog(
    onDismiss: () -> Unit,
) {
    SettingsDialog(
        onDismiss = onDismiss,
        settingsUiState = SettingsUiState.Success(UserEditableSettings(
            brand = ThemeBrand.ANDROID,
            darkThemeConfig = DarkThemeConfig.DARK,
            useDynamicColor = false

        )),
        onChangeThemeBrand = {},
        onChangeDynamicColorPreference = {},
        onChangeDarkThemeConfig = {},
    )
}



@Composable
fun SettingsDialog(
    settingsUiState: SettingsUiState,
    supportDynamicColor: Boolean = supportsDynamicTheming(),
    onDismiss: () -> Unit,
    onChangeThemeBrand: (themeBrand: ThemeBrand) -> Unit,
    onChangeDynamicColorPreference: (useDynamicColor: Boolean) -> Unit,
    onChangeDarkThemeConfig: (darkThemeConfig: DarkThemeConfig) -> Unit,

    ) {
    val configuration = LocalConfiguration.current
    /**
     * usePlatformDefaultWidth = false is use as a temporary fix to allow
     * height recalculation during recomposition. This, however, causes
     * Dialog's to occupy full width in Compact mode. Therefore max width
     * is configured below. This should be removed when there's fix to
     * https://issuetracker.google.com/issues/221643630
     */

    AlertDialog(
        properties = DialogProperties(usePlatformDefaultWidth = false),
        modifier = Modifier.widthIn(max = configuration.screenWidthDp.dp - 80.dp),
        onDismissRequest = { onDismiss()},
        title = {
            Text(
                text = stringResource(R.string.settings),
                style = MaterialTheme.typography.titleLarge,
            )
        },
        text = {
            Divider()
            Column(Modifier.verticalScroll(rememberScrollState())) {
                when (settingsUiState) {
                    SettingsUiState.Loading -> {
                        Text(
                            text = stringResource(R.string.loading),
                            modifier = Modifier.padding(vertical = 16.dp),
                        )
                    }

                    is SettingsUiState.Success -> {
                        SettingsPanel(
                            settings = settingsUiState.settings,
                            supportDynamicColor = supportDynamicColor,
                            onChangeThemeBrand = onChangeThemeBrand,
                            onChangeDynamicColorPreference = onChangeDynamicColorPreference,
                            onChangeDarkThemeConfig = onChangeDarkThemeConfig,
                        )
                    }
                }

                Divider(Modifier.padding(top = 8.dp))
                LinksPanel()
            }
        },
        confirmButton = {
            Text(
                text = stringResource(R.string.dismiss_dialog_button_text),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clickable { onDismiss() },
            )
        },
    )

}

@Composable
private fun SettingsPanel(
    settings: UserEditableSettings,
    supportDynamicColor: Boolean,
    onChangeThemeBrand: (themeBrand: ThemeBrand) -> Unit,
    onChangeDynamicColorPreference: (useDynamicColor: Boolean) -> Unit,
    onChangeDarkThemeConfig: (darkThemeConfig: DarkThemeConfig) -> Unit,
) {
    SettingsDialogSectionTitle(text = stringResource(R.string.theme))
    Column(Modifier.selectableGroup()) {
        SettingsDialogThemeChooserRow(
            text = stringResource(R.string.brand_default),
            selected = settings.brand == ThemeBrand.DEFAULT,
            onClick = { onChangeThemeBrand(ThemeBrand.DEFAULT) },
        )
        SettingsDialogThemeChooserRow(
            text = stringResource(R.string.brand_android),
            selected = settings.brand == ThemeBrand.ANDROID,
            onClick = { onChangeThemeBrand(ThemeBrand.ANDROID) },
        )
    }
    if (settings.brand == ThemeBrand.DEFAULT && supportDynamicColor) {
        SettingsDialogSectionTitle(text = stringResource(R.string.dynamic_color_preference))
        Column(Modifier.selectableGroup()) {
            SettingsDialogThemeChooserRow(
                text = stringResource(R.string.dynamic_color_yes),
                selected = settings.useDynamicColor,
                onClick = { onChangeDynamicColorPreference(true) },
            )
            SettingsDialogThemeChooserRow(
                text = stringResource(R.string.dynamic_color_no),
                selected = !settings.useDynamicColor,
                onClick = { onChangeDynamicColorPreference(false) },
            )
        }
    }
    SettingsDialogSectionTitle(text = stringResource(R.string.dark_mode_preference))
    Column(Modifier.selectableGroup()) {
        SettingsDialogThemeChooserRow(
            text = stringResource(R.string.dark_mode_config_system_default),
            selected = settings.darkThemeConfig == DarkThemeConfig.FOLLOW_SYSTEM,
            onClick = { onChangeDarkThemeConfig(DarkThemeConfig.FOLLOW_SYSTEM) },
        )
        SettingsDialogThemeChooserRow(
            text = stringResource(R.string.dark_mode_config_light),
            selected = settings.darkThemeConfig == DarkThemeConfig.LIGHT,
            onClick = { onChangeDarkThemeConfig(DarkThemeConfig.LIGHT) },
        )
        SettingsDialogThemeChooserRow(
            text = stringResource(R.string.dark_mode_config_dark),
            selected = settings.darkThemeConfig == DarkThemeConfig.DARK,
            onClick = { onChangeDarkThemeConfig(DarkThemeConfig.DARK) },
        )
    }



}



@Composable
private fun SettingsDialogSectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
    )
}

@Composable
fun SettingsDialogThemeChooserRow(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    Row(
        Modifier
            .fillMaxWidth()
            .selectable(
                selected = selected,
                role = Role.RadioButton,
                onClick = onClick,
            )
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        RadioButton(
            selected = selected,
            onClick = null,
        )
        Spacer(Modifier.width(8.dp))
        Text(text)
    }
}

@Composable
private fun LinksPanel() {
    Row(
        modifier = Modifier.padding(top = 16.dp),
    ) {
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row {
                TextLink(
                    text = stringResource(R.string.privacy_policy),
                    url = PRIVACY_POLICY_URL,
                )
                Spacer(Modifier.width(16.dp))
                TextLink(
                    text = stringResource(R.string.licenses),
                    url = LICENSES_URL,
                )
            }
            Spacer(Modifier.height(16.dp))
            Row {
                TextLink(
                    text = stringResource(R.string.brand_guidelines),
                    url = BRAND_GUIDELINES_URL,
                )
                Spacer(Modifier.width(16.dp))
                TextLink(
                    text = stringResource(R.string.feedback),
                    url = FEEDBACK_URL,
                )
            }
        }
    }
}



@Composable
private fun TextLink(text: String, url: String) {
    val launchResourceIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    val context = LocalContext.current

    Text(
        text = text,
        style = MaterialTheme.typography.labelLarge,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .clickable {
                ContextCompat.startActivity(context, launchResourceIntent, null)
            },
    )
}

@Preview
@Composable
private fun PreviewSettingsDialog() {
    ExamGptTheme {
        SettingsDialog(
            onDismiss = {},
            settingsUiState = SettingsUiState.Success(
                UserEditableSettings(
                    brand = ThemeBrand.DEFAULT,
                    darkThemeConfig = DarkThemeConfig.FOLLOW_SYSTEM,
                    useDynamicColor = false,
                ),
            ),
            onChangeThemeBrand = {},
            onChangeDynamicColorPreference = {},
            onChangeDarkThemeConfig = {},
        )
    }
}

@Preview
@Composable
private fun PreviewSettingsDialogLoading() {
    ExamGptTheme {
        SettingsDialog(
            onDismiss = {},
            settingsUiState = SettingsUiState.Loading,
            onChangeThemeBrand = {},
            onChangeDynamicColorPreference = {},
            onChangeDarkThemeConfig = {},
        )
    }
}





/* ktlint-disable max-line-length */
private const val PRIVACY_POLICY_URL = "https://policies.google.com/privacy"
private const val LICENSES_URL =
    "https://github.com/android/nowinandroid/blob/main/app/LICENSES.md#open-source-licenses-and-copyright-notices"
private const val BRAND_GUIDELINES_URL =
    "https://developer.android.com/distribute/marketing-tools/brand-guidelines"
private const val FEEDBACK_URL = "https://goo.gle/nia-app-feedback"
