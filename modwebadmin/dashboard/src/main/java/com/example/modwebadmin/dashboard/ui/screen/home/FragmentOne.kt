package com.example.modwebadmin.dashboard.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.modwebadmin.dashboard.R
import com.example.modwebadmin.dashboard.ui.screen.home.viewmodel.HomeViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.*
import com.iddevops.core.main.util.toDp


@Composable
fun FragmentOne(
    modifier: Modifier = Modifier,
    vm: HomeViewModel = viewModel()
) = Box(modifier) {

    Map(
        modifier = Modifier.fillMaxSize()
    )

    Image(
        painter = painterResource(R.drawable.ic_bg_hotspot_radius),
        contentDescription = "Hotspot Area",
        modifier = Modifier
            .height(400.toDp)
            .width(400.toDp)
            .align(Alignment.Center)
    )

    PreviewItem(
        modifier = Modifier
            .align(Alignment.Center)
    )

    Image(
        painter = painterResource(
            R.drawable.ic_baseline_location_on_24
        ),
        colorFilter = ColorFilter.tint(Color.Red),
        contentDescription = "Pointer",
        modifier = Modifier.height(64.toDp).width(64.toDp).align(Alignment.Center).offset(y = (-32).toDp)
    )
}

@Composable
fun Map(
    modifier: Modifier = Modifier,
    vm: HomeViewModel = viewModel()
) = Box(modifier) {

    val latLng = vm.location.collectAsState()
    val uiSettings by remember {
        mutableStateOf(
            MapUiSettings().copy(
                zoomControlsEnabled = false
            )
        )
    }
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(latLng.value, 18f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        properties = MapProperties(mapType = MapType.NORMAL),
        uiSettings = uiSettings,
        cameraPositionState = cameraPositionState
    )

    LaunchedEffect(cameraPositionState.position.target) {
        vm.updateLocation(cameraPositionState.position.target)
    }
}

@Composable
fun PreviewItem(
    modifier: Modifier = Modifier,
    vm: HomeViewModel = viewModel()
) = Box(
    modifier = Modifier
        .height(400.toDp)
        .width(400.toDp)
        .then(modifier)
) {
    val items = listOf(
        R.drawable.img_beras,
        R.drawable.img_sayur,
        R.drawable.img_galon,
        R.drawable.img_galon,
        R.drawable.img_beras,
        R.drawable.img_sayur,
    )
    if (vm.isItemLoading.collectAsState().value.not()) {
        items.shuffled().subList(0, (Math.random() * 6).toInt()).map {
            Box(
                modifier = Modifier
                    .height(128.toDp)
                    .width(128.toDp)
                    .offset(
                        x = (Math.random() * 278).toInt().toDp,
                        y = (Math.random() * 278).toInt().toDp
                    )
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_map_item_frame),
                    contentDescription = "Frame Item",
                    modifier = Modifier.fillMaxSize()
                )
                Image(
                    modifier = Modifier
                        .height(80.toDp)
                        .width(80.toDp)
                        .clip(CircleShape)
                        .align(Alignment.Center),
                    contentDescription = "Image Item",
                    painter = painterResource(it),
                )
            }
        }
    }
}