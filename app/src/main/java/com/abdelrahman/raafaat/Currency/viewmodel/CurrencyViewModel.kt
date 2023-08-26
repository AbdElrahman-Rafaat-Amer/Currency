package com.abdelrahman.raafaat.currency.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdelrahman.raafaat.currency.model.Repository
import com.abdelrahman.raafaat.currency.model.RepositoryInterface
import com.abdelrahman.raafaat.currency.network.CurrencyClient
import kotlinx.coroutines.launch

class CurrencyViewModel : ViewModel() {

    private var repository: RepositoryInterface = Repository.getCurrencyClient(CurrencyClient.getCurrencyClient())

    private var _currencies: MutableLiveData<List<String>> = MutableLiveData()
    var currencies : LiveData<List<String>> = _currencies

    fun getSymbols() {
        viewModelScope.launch {
            val response = repository.getSymbols()
            if (response.isSuccessful){
                val symbolsResponse = response.body()
                if (symbolsResponse?.isSuccess == true){
                    val symbols = symbolsResponse.currencies?.keys
                    if (!symbols.isNullOrEmpty()){
                        _currencies.postValue(symbols.toList())
                    }else{
                        _currencies.postValue(emptyList())
                    }
                }else{
                    _currencies.postValue(emptyList())
                }
            }else{
                _currencies.postValue(emptyList())
            }
        }

    }
}