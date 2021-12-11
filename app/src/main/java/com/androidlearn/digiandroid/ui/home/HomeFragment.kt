package com.androidlearn.digiandroid.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidlearn.digiandroid.databinding.FragmentHomeBinding
import com.androidlearn.digiandroid.models.BaseModel
import com.androidlearn.digiandroid.ui.home.adapter.NewsAdapter
import com.androidlearn.digiandroid.ui.home.adapter.ProductAdapter
import com.androidlearn.digiandroid.ui.home.viewmodel.HomeViewModel
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

    lateinit var viewModel: HomeViewModel
    lateinit var owner: LifecycleOwner

    override fun onAttach(context: Context) {
        super.onAttach(context)
        owner = this
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

       // adView()
      //  adRequestIntertial()

       // allAdsCode()

        viewModel.getHomeData().observe(owner, Observer<BaseModel> {


            binding.pagerNews.adapter = activity?.let { it1 -> NewsAdapter(it1, it.news) }

            binding.recyclerMobiles.adapter = ProductAdapter(it.mobile)
            binding.recyclerMobiles.layoutManager = LinearLayoutManager(activity , LinearLayoutManager.HORIZONTAL , false)


            binding.recyclerMakeup.adapter = ProductAdapter(it.makeup)
            binding.recyclerMakeup.layoutManager = LinearLayoutManager(activity , LinearLayoutManager.HORIZONTAL , false)

            binding.recyclerDiscount.adapter = ProductAdapter(it.discount)
            binding.recyclerDiscount.layoutManager = LinearLayoutManager(activity , LinearLayoutManager.HORIZONTAL , false)




        })




        return binding.root
    }

    private fun HomeFragment.allAdsCode() {
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
    }

    private fun adRequestIntertial() {
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
    }

    private fun adView() {
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