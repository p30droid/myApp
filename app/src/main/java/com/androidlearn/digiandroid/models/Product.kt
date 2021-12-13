package com.androidlearn.digiandroid.models
import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize


@Parcelize
data class Product(
    val brand: String,
    val catId: String,
    val catName: String,
    val count: String,
    val discount: String,
    val fullDescription: String,
    val gallery: List<Gallery>,
    val garanti: String,
    val icon: String,
    val id: String,
    val price: String,
    val rate: String,
    val shortDescription: String,
    val special: String,
    val title: String
): Parcelable {
    /*private companion object : Parceler<Product> {
        override fun Product.write(parcel: Parcel, flags: Int) {
            parcel.writeString(this.brand)
            parcel.writeString(this.catId)
            parcel.writeString(this.catName)
            parcel.writeString(this.count)
            parcel.writeString(this.discount)
            parcel.writeString(this.fullDescription)
            parcel.writeString(this.gallery)
            parcel.writeString(this.garanti)
            parcel.writeString(this.icon)
            parcel.writeString(this.id)
            parcel.writeString(this.price)
            parcel.writeString(this.rate)
            parcel.writeString(this.shortDescription)
            parcel.writeString(this.special)
            parcel.writeString(this.title)

        }

        override fun create(parcel: Parcel): Product {
            // Custom read implementation
        }
    }*/
}