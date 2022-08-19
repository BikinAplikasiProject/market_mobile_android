package com.bikinaplikasiproject.market.ui.screen.smart

import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.bikinaplikasiproject.market.R
import com.bikinaplikasiproject.market.domain.model.MarketIdentifier
import com.google.accompanist.systemuicontroller.SystemUiController
import com.iddevops.control.provider.buyer.StoreSpace
import com.iddevops.core.ui.ui.component.text.TextTitle2
import com.iddevops.core.ui.ui.theme.ContentThemeWrapper
import com.iddevops.core.ui.ui.theme.color.NeutralBlack
import com.iddevops.core.ui.ui.theme.color.NeutralWhite
import com.iddevops.core.ui.ui.theme.dp156
import com.iddevops.core.ui.ui.theme.dp16
import com.iddevops.core.ui.ui.theme.dp8

@Composable
fun SmartScreen(
    systemUiController: SystemUiController? = null,
    storeLauncher: ActivityResultLauncher<StoreSpace.Payload>? = null
) {
    val items = remember {
        listOf(
            MarketIdentifier(
                "1",
                "Indomaret Bahagia",
                "file:///android_asset/indomaret.jpg"
            ),
            MarketIdentifier(
                "2",
                "Alfamart Bahagia",
                "file:///android_asset/alfamart.jpg"
            ),
            MarketIdentifier(
                "4",
                "W-Gym",
                "file:///android_asset/wgym.jpg"
            )
        )
    }

    LaunchedEffect(key1 = systemUiController) {
        systemUiController?.setSystemBarsColor(
            color = NeutralBlack
        )
    }

    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(color = NeutralBlack)
    ) {
        item {
            TextTitle2(
                text = "Disekitar anda",
                color = NeutralWhite,
                modifier = Modifier.padding(dp16, dp16, dp16, dp8)
            )
        }

        items.map {
            item(key = it.id) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dp16, dp16, dp16, dp8)
                ) {
                    Items(data = it) {
                        storeLauncher?.launch(StoreSpace.Payload())
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Items(data: MarketIdentifier, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(dp156),
        onClick = { onClick.invoke() }
    ) {
        Row {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(color = Color.Red)
            ) {
                AsyncImage(
                    model = data.imageUrl,
                    placeholder = painterResource(R.drawable.img_placeholder),
                    contentDescription = "Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
            ) {
                TextTitle2(
                    text = data.name ?: "",
                    modifier = Modifier
                        .align(Alignment.Center),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
@Preview(showSystemUi = false)
fun Preview0() {
    Box(
        Modifier.background(color = NeutralBlack)
    ) {
        ContentThemeWrapper(
            modifier = Modifier.padding(dp16),
            forceDark = true
        ) {
            Items(
                data = MarketIdentifier(
                    "1",
                    "Indomaret Bahagia",
                    "file:///android_asset/indomaret.jpg"
                )
            ) {}
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview1() {
    ContentThemeWrapper(
        forceDark = true
    ) {
        SmartScreen()
    }
}