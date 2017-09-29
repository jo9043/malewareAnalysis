rule dropper:realshell android {
    meta:
    author = "https://twitter.com/plutec_net"
    reference = "https://koodous.com/"
    source = "https://blog.malwarebytes.org/mobile-2/2015/06/complex-method-of-obfuscation-found-in-dropper-realshell/"

    strings:
    $b = "Decrypt.malloc.memset.free.pluginSMS_encrypt.Java_com_skymobi_pay_common_util_LocalDataDecrpty_Encrypt.strcpy"

    condition:
    $b
}