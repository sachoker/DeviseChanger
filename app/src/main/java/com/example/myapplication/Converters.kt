package Converters

import android.os.AsyncTask
import android.util.Log
import org.json.JSONException

class Converter() : AsyncTask<String, Void, Double>() {

    override fun doInBackground(vararg params: String): Double {
        val obj = khttp.get(
            "https://api.exchangeratesapi.io/latest",
            params = mapOf("symbols" to params[1], "base" to params[0])
        ).jsonObject
        Log.d("TAG", "false")
        var rate: Double = 1.0
        rate = try {
            obj.getJSONObject("rates").getDouble(params[1])
        } catch (e: JSONException) {
            1.0
        }
        return rate
    }
}
