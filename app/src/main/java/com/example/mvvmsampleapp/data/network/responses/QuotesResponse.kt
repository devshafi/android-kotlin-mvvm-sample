package com.example.mvvmsampleapp.data.network.responses

import com.example.mvvmsampleapp.data.db.entities.Quote

class QuotesResponse (
    val isSuccessfull:Boolean,
    val quotes: List<Quote>
)