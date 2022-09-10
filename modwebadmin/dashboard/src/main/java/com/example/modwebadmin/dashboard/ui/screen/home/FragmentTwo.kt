package com.example.modwebadmin.dashboard.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.modwebadmin.dashboard.ui.screen.home.viewmodel.HomeViewModel
import com.iddevops.core.main.domain.model.NOTHING
import com.iddevops.core.main.util.toDp
import com.iddevops.core.ui.ui.component.text.TextRegularStandard
import com.iddevops.core.ui.ui.component.text.TextTitle2
import com.iddevops.core.ui.ui.component.text.TextTitle3


@Composable
fun FragmentTwo() = Card(
    shape = RectangleShape
) {
    Column(
        modifier = Modifier.background(Color(0xff4a6d88))
    ) {
        LocationStatus(modifier = Modifier.width(400.toDp))
        NavigatorCard(modifier = Modifier.fillMaxHeight().width(400.toDp))
    }
}

@Composable
fun LocationStatus(
    modifier: Modifier = Modifier,
    vm: HomeViewModel = viewModel()
) = Box(
    modifier = Modifier
        .then(modifier)
        .padding(16.toDp)
) {
    val latlng = vm.location.collectAsState().value
    Column {
        TextTitle2(
            "Location name : Mbuh Some Where",
            color = Color.White
        )
        TextRegularStandard(
            "Latitude : ${latlng.latitude}",
            color = Color.White
        )
        TextRegularStandard(
            "Longitude : ${latlng.longitude}",
            color = Color.White
        )
    }
}

@Composable
fun NavigatorCard(
    modifier: Modifier = Modifier,
    vm: HomeViewModel = viewModel()
) = Box(
    modifier = Modifier.then(modifier)
) {
    val items = vm.item.collectAsState().value

    LazyColumn(
        userScrollEnabled = true
    ) {
        item {
            Spacer(
                modifier = Modifier.height(16.toDp)
            )
        }
        items.subList(0, (Math.random() * 20).toInt()).map {
            item { NavigatorCards(it) }
        }
    }

    if (vm.isItemLoading.collectAsState().value) {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(Color(0x55000000))
        ) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NavigatorCards(
    items: NOTHING
) = Box(
    modifier = Modifier
        .padding(16.toDp, 8.toDp, 16.toDp, 8.toDp)
) {
    Card(
        onClick = {

        },
        modifier = Modifier
            .fillMaxWidth()
            .height(100.toDp),
        shape = RoundedCornerShape(16.toDp),
    ) {
        Box(
            modifier = Modifier.padding(16.toDp)
                .background(Color.Transparent)
        ) {
            TextTitle3("Element $items")
        }
    }
}