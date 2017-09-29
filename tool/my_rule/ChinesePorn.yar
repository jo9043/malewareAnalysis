rule Sensual_woman: chinese android
{
	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of ChinesePorn"
	reference = "https://koodous.com/"

	strings:
	$pkg0 = "com.phone.gzlok.live"
	$pkg1 = "com.yongrun.app.sxmn"
	$pkg2 = "com.wnm.zycs"
	$pkg3 = "com.charile.chen/i"
	$pkg4 = "com.sp.meise/i"
	$pkg5 = "com.legame.wfxk.wjyg"
	$pkg6 = "com.video.uiA/i"

	condition:
	any of them
}

rule Chinese2 : sms_sender android
{
  	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of ChinesePorn SMS send"
	reference = "https://koodous.com/"

	strings:
	$pkg0 = "com.adr.yykbplayer"
	$pkg1 = "sdej.hpcite.icep"
	$pkg2 = "p.da.wdh"
	$pkg3 = "com.shenqi.video.sjyj.gstx"
	$pkg4 = "cjbbtwkj.xyduzi.fa"
	$pkg5 = "kr.mlffstrvwb.mu"

	condition:
	any of them
}

rule chinese_porn : SMSSend android
{
  	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of ChinesePorn SMS send"
	reference = "https://koodous.com/"

	strings:
	$pkg0 = "com.tzi.shy"
	$pkg1 = "com.shenqi.video.nfkw.neim"

	condition:
	any of them
}

rule chineseporn4 : SMSSend android
{
  	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of ChinesePorn SMS send"
	reference = "https://koodous.com/"

	strings:
	$act = "com.shenqi.video.Welocme"
	$pkg = "org.mygson.videoa.zw"

	condition:
	any of them
}

rule chineseporn5 : SMSSend android
{
  	meta:
	author ="https://www.github.com/jo9043"
	description = "Detection of ChinesePorn SMS send"
	reference = "https://koodous.com/"

	strings:
	$pkg0 = "com.shenqi.video.ycef.svcr"
	$pkg1 = "dxas.ixa.xvcekbxy"
	$pkg2 = "com.video.ui"
	$pkg3 = "com.qq.navideo"
	$pkg4 = "com.android.sxye.wwwl"
	$issuer = "llfovtfttfldddcffffhhh"

	condition:
	any of them

}
