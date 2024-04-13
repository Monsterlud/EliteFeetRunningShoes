package com.udacity.elitefeetrunningshoes.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.elitefeetrunningshoes.models.Shoe
import java.util.Locale

class ShoeViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String>
        get() = _toastMessage

    private val _navigateBack: MutableLiveData<Boolean> = MutableLiveData(false)
    val navigateBack: LiveData<Boolean>
        get() = _navigateBack

    val name: MutableLiveData<String> = MutableLiveData("")
    val company: MutableLiveData<String> = MutableLiveData("")
    val description: MutableLiveData<String> = MutableLiveData("")
    val shoeSize: MutableLiveData<String> = MutableLiveData("")
    val imageUrl: MutableLiveData<String> = MutableLiveData("")

    init {
        setShoeList()
    }

    fun addShoe() {
        var size: Double = 0.0
        try {
            size = shoeSize.value.toString().toDouble()
        } catch (e: NumberFormatException) {
            _toastMessage.value = "Shoe size must be a number"
            return
        }
        val shoe = Shoe(
            name = name.value.toString().capitalizeFirstletter(),
            size = size,
            company = company.value.toString().capitalizeFirstletter(),
            description = description.value.toString(),
            images = listOf(imageUrl.value.toString())
        )
        if (name.value?.isEmpty() == true || company.value?.isEmpty() == true || description.value?.isEmpty() == true || imageUrl.value?.isEmpty() == true) {
            _toastMessage.value = "All fields must be filled out"
            return
        }
        _shoeList.value = _shoeList.value?.plus(shoe)
        clearEditTexts()
        _navigateBack.value = true
    }

    fun resetNavigateBack() {
        _navigateBack.value = false
    }

    private fun clearEditTexts() {
        name.value = ""
        company.value = ""
        description.value = ""
        shoeSize.value = ""
        imageUrl.value = ""
    }

    fun clearToastMessage() {
        _toastMessage.value = ""
    }


    fun String.capitalizeFirstletter(): String {
        return this.replaceFirstChar {
            if (it.isLowerCase()) {
                it.titlecase(Locale.getDefault())
            } else it.toString()
        }
    }

    private fun setShoeList() {
        _shoeList.value =
            mutableListOf(
                Shoe(
                    "Vaporfly 3",
                    9.0,
                    "Nike",
                    "road racing",
                    listOf(
                        "https://www.nike.com/t/alphafly-3-mens-road-racing-shoes-6Nc43S/" +
                                "FD8311-700?_gl=1*1eq92ol*_up*MQ..&gclid=Cj0KCQjwztOwBhD7ARIsAPDK" +
                                "nkBTwhStCeMqXQwLSXyRKoHdEYt4uaHsfBS7BpOy1GSNHsrLVdRPimgaAtn_EALw_wcB&gclsrc=aw.ds",
                    ),
                ),
                Shoe(
                    "Alphafly 3",
                    8.0,
                    "Nike",
                    "road racing",
                    listOf("https://www.nike.com/t/vaporfly-3-mens-road-racing-shoes-8DD182/DV4129-700"),
                ),
                Shoe(
                    "Pegasus 40",
                    7.5,
                    "Nike",
                    "daily trainer",
                    listOf("https://www.nike.com/t/pegasus-40-mens-road-running-shoes-extra-wide-zD8H1c/DV3853-102"),
                ),
                Shoe(
                    "ZoomX Dragonfly",
                    11.0,
                    "Nike",
                    "track & field distance spikes",
                    listOf(
                        "https://www.nike.com/t/pegasus-40-mens-road-running-shoes-extra-wide-z" +
                                "D8H1c/DV3853-102https://www.nike.com/t/zoomx-dragoy-track-field-distance-spikes-0P9jtc/CV0400-101",
                    ),
                ),
                Shoe(
                    "Adizero Adios Pro 3M",
                    10.5,
                    "Adidas",
                    "road racing",
                    listOf("https://www.adidas.com/us/adizero-adios-pro-3-m/IG6441.html"),
                ),
                Shoe(
                    "Adizero Takumi Sen 10M",
                    9.5,
                    "Adidas",
                    "road racing",
                    listOf("https://www.adidas.com/us/adizero-takumi-sen-10-m/IG8202.html"),
                ),
                Shoe(
                    "Adizero Boston 12",
                    9.0,
                    "Adidas",
                    "daily trainer",
                    listOf("https://www.adidas.com/us/adizero-boston-12-running-shoes/IG3320.html"),
                ),
                Shoe(
                    "Adizero Prime X 2.0 Strung",
                    8.0,
                    "Adidas",
                    "max cushioned",
                    listOf("https://www.adidas.com/us/adizero-prime-x-2.0-strung-running-shoes/ID0264.html"),
                ),
                Shoe(
                    "Supernova Rise M",
                    8.5,
                    "Adidas",
                    "daily trainer",
                    listOf("https://www.adidas.com/us/supernova-rise-m/IH7613.html"),
                ),
                Shoe(
                    "Gel-Cumulus 26 Limited Edition",
                    12.5,
                    "Asics",
                    "max cushioned",
                    listOf("https://www.asics.com/us/en-us/gel-cumulus-26-limited-edition/p/ANA_1011B943-400.html"),
                ),
                Shoe(
                    "Metaspeed Sky Paris",
                    12.0,
                    "Asics",
                    "road racing",
                    listOf("https://www.asics.com/us/en-us/metaspeed-sky-paris/p/ANA_1013A123-600.html"),
                ),
                Shoe(
                    "Metaspeed Edge Paris",
                    10.0,
                    "Asics",
                    "road racing",
                    listOf("https://www.asics.com/us/en-us/metaspeed-edge-paris/p/ANA_1013A124-600.html"),
                ),
                Shoe(
                    "Superblast",
                    7.0,
                    "Asics",
                    "max cushioned",
                    listOf("https://www.asics.com/us/en-us/superblast/p/ANA_1013A127-600.html"),
                ),
                Shoe(
                    "Novablast 4",
                    9.0,
                    "Asics",
                    "daily trainer",
                    listOf("https://www.asics.com/us/en-us/novablast-4/p/ANA_1011B693-601.html"),
                ),
                Shoe(
                    "Endorphin Speed 4",
                    9.5,
                    "Saucony",
                    "daily trainer",
                    listOf(
                        "https://www.saucony.com/en/endorphin-speed-4/58852M.html?dwvar_58852M_" +
                                "color=S20940-129#cgid=mens-running&prefn1=isOnSale&prefv1=false&start=1",
                    ),
                ),
                Shoe(
                    "Kinvara Pro",
                    11.0,
                    "Saucony",
                    "daily trainer",
                    listOf(
                        "https://www.saucony.com/en/kinvara-pro/56633M.html?dwvar_56633M_color=" +
                                "S20847-138#cgid=mens-running&prefn1=isOnSale&prefv1=false&start=1",
                    ),
                ),
                Shoe(
                    "Endorphin Pro 3",
                    10.5,
                    "Saucony",
                    "road racing",
                    listOf(
                        "https://www.saucony.com/en/endorphin-pro-3/52954M.html?dwvar_52954M_color=" +
                                "S20755-33#cgid=mens-running&prefn1=isOnSale&prefv1=false&start=1",
                    ),
                ),
                Shoe(
                    "FuelCell SuperComp Elite v4",
                    7.0,
                    "New Balance",
                    "road racing",
                    listOf(
                        "https://www.newbalance.com/pd/fuelcell-supercomp-elite-v4/MRCELV4-44901.html?" +
                                "dwvar_MRCELV4-44901_style=MRCELLA4",
                    ),
                ),
                Shoe(
                    "FuelCell SuperComp Elite v4",
                    8.0,
                    "New Balance",
                    "road racing",
                    listOf(
                        "https://www.newbalance.com/pd/fuelcell-supercomp-elite-v4/MRCELV4-44901.html?" +
                                "dwvar_MRCELV4-44901_style=MRCELLA4",
                    ),
                ),
                Shoe(
                    "FuelCell Rebel v4",
                    9.0,
                    "New Balance",
                    "daily trainer",
                    listOf(
                        "https://www.newbalance.com/pd/fuelcell-rebel-v4/MFCXV4-41132.html?dwvar_" +
                                "MFCXV4-41132_style=MFCXLK4",
                    ),
                ),
                Shoe(
                    "FuelCell SuperComp Trainer v2",
                    9.5,
                    "New Balance",
                    "max cushioned",
                    listOf(
                        "https://www.newbalance.com/pd/fuelcell-supercomp-trainer-v2/MRCXV3-45183.html?" +
                                "dwvar_MRCXV3-45183_style=MRCXCA3",
                    ),
                ),
                Shoe(
                    "Wave Rebellion Pro 2",
                    13.0,
                    "Mizuno",
                    "road racing",
                    listOf("https://mizunousa.com/running-wave-rebellion-pro-2-mens"),
                ),
                Shoe(
                    "Wave Rebellion Flash 2",
                    12.0,
                    "Mizuno",
                    "max cushioned",
                    listOf("https://mizunousa.com/running-wave-rebellion-flash-2-mens"),
                ),
            )
    }
}
