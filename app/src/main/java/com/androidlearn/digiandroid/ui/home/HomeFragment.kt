package com.androidlearn.digiandroid.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.androidlearn.digiandroid.databinding.FragmentHomeBinding
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private var mInterstitialAd: InterstitialAd? = null
    private lateinit var rewardedAd: RewardedAd


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(layoutInflater)


        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)

        binding.adView.adListener = object : AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.e("adListener", "onAdLoaded");
            }

            override fun onAdFailedToLoad(adError: LoadAdError) {
                // Code to be executed when an ad request fails.
                Log.e("adListener", "onAdFailedToLoad " + adError.code);
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.e("adListener", "onAdOpened");
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                Log.e("adListener", "onAdClicked");
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                Log.e("adListener", "onAdClosed");
            }
        }


        var adRequest_intertial = AdRequest.Builder().build()

        InterstitialAd.load(
            activity,
            "ca-app-pub-3940256099942544/1033173712",
            adRequest_intertial,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d("InterstitialAd", adError?.message)
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d("InterstitialAd", "Ad was loaded.")
                    mInterstitialAd = interstitialAd

                    if (mInterstitialAd != null) {
                        mInterstitialAd?.show(activity)
                    } else {
                        Log.d("TAG", "The interstitial ad wasn't ready yet.")
                    }
                }
            })

        /*  mInterstitialAd?.fullScreenContentCallback = object: FullScreenContentCallback() {
              override fun onAdDismissedFullScreenContent() {
                  Log.d(TAG, 'Ad was dismissed.')
              }

              override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                  Log.d(TAG, 'Ad failed to show.')
              }

              override fun onAdShowedFullScreenContent() {
                  Log.d(TAG, 'Ad showed fullscreen content.')
                  mInterstitialAd = null
              }
          }
  */

       // rewardedAd = RewardedAd()

        val fullScreenContentCallback: FullScreenContentCallback =
            object : FullScreenContentCallback() {
                override fun onAdShowedFullScreenContent() {
                    // Code to be invoked when the ad showed full screen content.
                }

                override fun onAdDismissedFullScreenContent() {
                    //  rewardedAd = null
                    // Code to be invoked when the ad dismissed full screen content.
                }
            }

        RewardedAd.load(
            activity,
            "adUnitId",
            AdRequest.Builder().build(),
            object : RewardedAdLoadCallback() {
                override fun onAdLoaded(ad: RewardedAd) {
                    // findViewById(R.id.display_button).setVisibility(View.VISIBLE)
                    rewardedAd = ad
                    rewardedAd.setFullScreenContentCallback(fullScreenContentCallback)
                }
            })

        binding.btnClick.setOnClickListener{
            onDisplayButtonClicked(it)
        }


        return binding.root
    }


    fun onDisplayButtonClicked(view: View) {
        rewardedAd.show(
            activity,
            OnUserEarnedRewardListener { rewardItem ->
                Toast.makeText(
                    activity,
                    "onRewarded! currency: "
                            + rewardItem.type + "    amount: "
                            + rewardItem.amount, Toast.LENGTH_SHORT
                ).show()
            })


    }
}