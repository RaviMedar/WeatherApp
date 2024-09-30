package com.ravi.weatherapp.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/ravi/weatherapp/network/GeocodingApiService;", "", "getCityCode", "", "Lcom/ravi/weatherapp/data/GeocodingResponse;", "city", "", "limit", "", "apiKey", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface GeocodingApiService {
    
    @retrofit2.http.GET(value = "direct")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCityCode(@retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull
    java.lang.String city, @retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "appid")
    @org.jetbrains.annotations.NotNull
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.ravi.weatherapp.data.GeocodingResponse>> $completion);
}