package com.sellercube.printserver;

import com.sellercube.printserver.utils.CoreUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrintServerApplicationTests {

	@Test
	public void contextLoads() throws Exception {
	    String a="JVBERi0xLjQKJcfsj6IKNSAwIG9iago8PC9MZW5ndGggNiAwIFIvRmlsdGVyIC9GbGF0ZURlY29k\n" +
                "ZT4+CnN0cmVhbQp4nN1WW3PiNhR+96/QTB9qMoOimy05bw7QHW8dyBpv6UynDy4IQguYtZ1s8+97\n" +
                "JNkJTgeyr7uTidHlXD+d2xdEEYE/913uvetMok3tEfQB/jfeF69/j25zIFGIMpSvPSZDzCKOAslw\n" +
                "KCjKV55/X1RLvVuX8EWLstqtvm5XGv2mq3pbHhDFhA7yv62MyIgQHFMlAzSkCoeEhlbGXFdPW+Af\n" +
                "lbudXjaG8a44bNe6bhxzhJRhHhIc0CjgFNgppiFhlr2jRbdFs3xAP90YpgjzIOLAlnr+idxx0eib\n" +
                "wc+9s3y7t2cywjSKGALTJFXKyiaEMCPO5+SaqGsqDS+VN4TAwiJDrGVcGoPQkBEsBBWWd1RU1VZX\n" +
                "aFoY+a0jjp4SBfha/OJsNEl/mcEXLWZZOl4k40kHWSvcUMMHyyiMLNNYH4uq2etD847wLLmboGwW\n" +
                "j1EyzSfZNM6T2TROUZrcJflkfEaPIsR5PyoPTVUsQcvj/i9dndcTUsUAm3fEde+cPx9fbVadKIqZ\n" +
                "oiywlJN/j5WuayQUSotqow3xJPc+AQcINwGLA/QVAhKJUJmXRntPwU2323nzM7FMqdNoWQFSahH9\n" +
                "AyCtjzZ8nKuDYcQDeFI4322fdPWM4tXKmAQXUhC4GD3WTbmH5x2VKz0YUkFCHJ7Qm4eBYwqJ4t+X\n" +
                "dbO0ZCxgHHIIoDisIEdQptcYqBTEs6R+0ug9aKCMMtCw0NvNQwM8TCkMLAWsKQdK5t+W5T9mI6Wx\n" +
                "pNwfMUr1k94NhioIAHDhf7T6/sw/OtyMu4EyCHdItbsLSLFXpITCYJRD6v7295gQKiWJ4AfwEByS\n" +
                "2v88TXIUoDjJ0mT66xwCbvx5nmdJnA5MJEQhlmfjcTDkAWF+vghQNM0MagGgyXyQzlkoMYn8IeAQ\n" +
                "RpFBaTozEAWGwCwZhaU7FdZ7oO35DTUnYJ3bbnPea/XqNBeAJO1HbtkUu/+HrsuCeTKGgE27LLC3\n" +
                "glFTVFoKyKd6uzmYxK37UqSJWyggjo72ZMCLh0KJ9s7GSJ9ZsG9ldiH1RjVYCFHZUpAe91AKAbLZ\n" +
                "mbJwEY43ReHHheOkGl8G5Bur8Y+LVNcRL8N0qSN+x9jYekS7vsVNQaRd3+p2l+qS66qGVYVd3/I/\n" +
                "ZPF0jPJZHqc3PRMDZqeZXlf9XpA6mSHCkLsw4tI64grtw/Z4hDCagzNF81i5YcLVe7CDiwhHzFR8\n" +
                "oV5370NrQpBT8YJtF63n1FB+qqbdnVfT+ssFtPqQwStiIpVrL1dXV2hyWKFyDQPBsawaBCf9fLKG\n" +
                "hSafGFZSOQtbYjfUtqDaMVuyF8RXB12vimfECYofNzC0IEbeVOUQZgHT6RgmihHetvliA0KhMcPQ\n" +
                "ryg860tP/eT9B+MH78BlbmRzdHJlYW0KZW5kb2JqCjYgMCBvYmoKMTAyOQplbmRvYmoKMTYgMCBv\n" +
                "YmoKPDwvTGVuZ3RoIDE3IDAgUi9GaWx0ZXIgL0ZsYXRlRGVjb2RlPj4Kc3RyZWFtCnic3VZbc+I2\n" +
                "FH73r9BMH2oyg6KbLTlvDtAdbx3IGm/pTKcPLghCC5i1nWzz73sk2QlOB7Kvu5OJ0eVcP53bF0QR\n" +
                "gT/3Xe6960yiTe0R9AH+N94Xr3+PbnMgUYgylK89JkPMIo4CyXAoKMpXnn9fVEu9W5fwRYuy2q2+\n" +
                "blca/aarelseEMWEDvK/rYzIiBAcUyUDNKQKh4SGVsZcV09b4B+Vu51eNobxrjhs17puHHOElGEe\n" +
                "EhzQKOAU2CmmIWGWvaNFt0WzfEA/3RimCPMg4sCWev6J3HHR6JvBz72zfLu3ZzLCNIoYAtMkVcrK\n" +
                "JoQwI87n5JqoayoNL5U3hMDCIkOsZVwag9CQESwEFZZ3VFTVVldoWhj5rSOOnhIF+Fr84mw0SX+Z\n" +
                "wRctZlk6XiTjSQdZK9xQwwfLKIws01gfi6rZ60PzjvAsuZugbBaPUTLNJ9k0zpPZNE5Rmtwl+WR8\n" +
                "Ro8ixHk/Kg9NVSxBy+P+L12d1xNSxQCbd8R175w/H19tVp0oipmiLLCUk3+Pla5rJBRKi2qjDfEk\n" +
                "9z4BBwg3AYsD9BUCEolQmZdGe0/BTbfbefMzsUyp02hZAVJqEf0DIK2PNnycq4NhxAN4UjjfbZ90\n" +
                "9Yzi1cqYBBdSELgYPdZNuYfnHZUrPRhSQUIcntCbh4FjConi35d1s7RkLGAccgigOKwgR1Cm1xio\n" +
                "FMSzpH7S6D1ooIwy0LDQ281DAzxMKQwsBawpB0rm35blP2YjpbGk3B8xSvWT3g2GKggAcOF/tPr+\n" +
                "zD863Iy7gTIId0i1uwtIsVekhMJglEPq/vb3mBAqJYngB/AQHJLa/zxNchSgOMnSZPrrHAJu/Hme\n" +
                "Z0mcDkwkRCGWZ+NxMOQBYX6+CFA0zQxqAaDJfJDOWSgxifwh4BBGkUFpOjMQBYbALBmFpTsV1nug\n" +
                "7fkNNSdgndtuc95r9eo0F4Ak7Udu2RS7/4euy4J5MoaATbsssLeCUVNUWgrIp3q7OZjErftSpIlb\n" +
                "KCCOjvZkwIuHQon2zsZIn1mwb2V2IfVGNVgIUdlSkB73UAoBstmZsnARjjdF4ceF46QaXwbkG6vx\n" +
                "j4tU1xEvw3SpI37H2Nh6RLu+xU1BpF3f6naX6pLrqoZVhV3f8j9k8XSM8lkepzc9EwNmp5leV/1e\n" +
                "kDqZIcKQuzDi0jriCu3D9niEMJqDM0XzWLlhwtV7sIOLCEfMVHyhXnfvQ2tCkFPxgm0XrefUUH6q\n" +
                "pt2dV9P6ywW0+pDBK2IilWsvV1dXaHJYoXINA8GxrBoEJ/18soaFJp8YVlI5C1tiN9S2oNoxW7IX\n" +
                "xFcHXa+KZ8QJih83MLQgRt5U5RBmAdPpGCaKEd62+WIDQqExw9CvKDzrS0/95P0H4wfvwGVuZHN0\n" +
                "cmVhbQplbmRvYmoKMTcgMCBvYmoKMTAyOQplbmRvYmoKNCAwIG9iago8PC9UeXBlL1BhZ2UvTWVk\n" +
                "aWFCb3ggWzAgMCA4NDEuNjggNTk1LjQ0XQovUm90YXRlIDAvUGFyZW50IDMgMCBSCi9SZXNvdXJj\n" +
                "ZXM8PC9Qcm9jU2V0Wy9QREYgL1RleHRdCi9FeHRHU3RhdGUgMTMgMCBSCi9Gb250IDE0IDAgUgo+\n" +
                "PgovQ29udGVudHMgNSAwIFIKPj4KZW5kb2JqCjE1IDAgb2JqCjw8L1R5cGUvUGFnZS9NZWRpYUJv\n" +
                "eCBbMCAwIDg0MS42OCA1OTUuNDRdCi9Sb3RhdGUgMC9QYXJlbnQgMyAwIFIKL1Jlc291cmNlczw8\n" +
                "L1Byb2NTZXRbL1BERiAvVGV4dF0KL0V4dEdTdGF0ZSAxOCAwIFIKL0ZvbnQgMTkgMCBSCj4+Ci9D\n" +
                "b250ZW50cyAxNiAwIFIKPj4KZW5kb2JqCjMgMCBvYmoKPDwgL1R5cGUgL1BhZ2VzIC9LaWRzIFsK\n" +
                "NCAwIFIKMTUgMCBSCl0gL0NvdW50IDIKPj4KZW5kb2JqCjEgMCBvYmoKPDwvVHlwZSAvQ2F0YWxv\n" +
                "ZyAvUGFnZXMgMyAwIFIKL01ldGFkYXRhIDIwIDAgUgo+PgplbmRvYmoKNyAwIG9iago8PC9UeXBl\n" +
                "L0V4dEdTdGF0ZQovT1BNIDEKL1RLIHRydWU+PmVuZG9iagoxMCAwIG9iago8PC9UeXBlL0V4dEdT\n" +
                "dGF0ZQovU0EgdHJ1ZT4+ZW5kb2JqCjEzIDAgb2JqCjw8L1IxMAoxMCAwIFIvUjcKNyAwIFI+Pgpl\n" +
                "bmRvYmoKMTQgMCBvYmoKPDwvUjExCjExIDAgUi9SMTIKMTIgMCBSL1I4CjggMCBSL1I5CjkgMCBS\n" +
                "Pj4KZW5kb2JqCjE4IDAgb2JqCjw8L1IxMAoxMCAwIFIvUjcKNyAwIFI+PgplbmRvYmoKMTkgMCBv\n" +
                "YmoKPDwvUjExCjExIDAgUi9SMTIKMTIgMCBSL1I4CjggMCBSL1I5CjkgMCBSPj4KZW5kb2JqCjEx\n" +
                "IDAgb2JqCjw8L0Jhc2VGb250L1RpbWVzLUJvbGQvVHlwZS9Gb250Ci9TdWJ0eXBlL1R5cGUxPj4K\n" +
                "ZW5kb2JqCjEyIDAgb2JqCjw8L0Jhc2VGb250L1RpbWVzLVJvbWFuL1R5cGUvRm9udAovU3VidHlw\n" +
                "ZS9UeXBlMT4+CmVuZG9iago4IDAgb2JqCjw8L0Jhc2VGb250L0hlbHZldGljYS1Cb2xkL1R5cGUv\n" +
                "Rm9udAovU3VidHlwZS9UeXBlMT4+CmVuZG9iago5IDAgb2JqCjw8L0Jhc2VGb250L0hlbHZldGlj\n" +
                "YS9UeXBlL0ZvbnQKL1N1YnR5cGUvVHlwZTE+PgplbmRvYmoKMjAgMCBvYmoKPDwvVHlwZS9NZXRh\n" +
                "ZGF0YQovU3VidHlwZS9YTUwvTGVuZ3RoIDEzMTk+PnN0cmVhbQo8P3hwYWNrZXQgYmVnaW49J++7\n" +
                "vycgaWQ9J1c1TTBNcENlaGlIenJlU3pOVGN6a2M5ZCc/Pgo8P2Fkb2JlLXhhcC1maWx0ZXJzIGVz\n" +
                "Yz0iQ1JMRiI/Pgo8eDp4bXBtZXRhIHhtbG5zOng9J2Fkb2JlOm5zOm1ldGEvJyB4OnhtcHRrPSdY\n" +
                "TVAgdG9vbGtpdCAyLjkuMS0xMywgZnJhbWV3b3JrIDEuNic+CjxyZGY6UkRGIHhtbG5zOnJkZj0n\n" +
                "aHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIycgeG1sbnM6aVg9J2h0\n" +
                "dHA6Ly9ucy5hZG9iZS5jb20vaVgvMS4wLyc+CjxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSc5\n" +
                "MTM5NGYzNC1jNTdhLTExZjItMDAwMC0xN2RiNDZjYmIzMzcnIHhtbG5zOnBkZj0naHR0cDovL25z\n" +
                "LmFkb2JlLmNvbS9wZGYvMS4zLycgcGRmOlByb2R1Y2VyPSdHUEwgR2hvc3RzY3JpcHQgOC43MCcv\n" +
                "Pgo8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0nOTEzOTRmMzQtYzU3YS0xMWYyLTAwMDAtMTdk\n" +
                "YjQ2Y2JiMzM3JyB4bWxuczp4bXA9J2h0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8nPjx4bXA6\n" +
                "TW9kaWZ5RGF0ZT4yMDE3LTA4LTMwVDEwOjM0OjIwKzAyOjAwPC94bXA6TW9kaWZ5RGF0ZT4KPHht\n" +
                "cDpDcmVhdGVEYXRlPjIwMTctMDgtMzBUMTA6MzQ6MjArMDI6MDA8L3htcDpDcmVhdGVEYXRlPgo8\n" +
                "eG1wOkNyZWF0b3JUb29sPlVua25vd25BcHBsaWNhdGlvbjwveG1wOkNyZWF0b3JUb29sPjwvcmRm\n" +
                "OkRlc2NyaXB0aW9uPgo8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0nOTEzOTRmMzQtYzU3YS0x\n" +
                "MWYyLTAwMDAtMTdkYjQ2Y2JiMzM3JyB4bWxuczp4YXBNTT0naHR0cDovL25zLmFkb2JlLmNvbS94\n" +
                "YXAvMS4wL21tLycgeGFwTU06RG9jdW1lbnRJRD0nOTEzOTRmMzQtYzU3YS0xMWYyLTAwMDAtMTdk\n" +
                "YjQ2Y2JiMzM3Jy8+CjxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSc5MTM5NGYzNC1jNTdhLTEx\n" +
                "ZjItMDAwMC0xN2RiNDZjYmIzMzcnIHhtbG5zOmRjPSdodHRwOi8vcHVybC5vcmcvZGMvZWxlbWVu\n" +
                "dHMvMS4xLycgZGM6Zm9ybWF0PSdhcHBsaWNhdGlvbi9wZGYnPjxkYzp0aXRsZT48cmRmOkFsdD48\n" +
                "cmRmOmxpIHhtbDpsYW5nPSd4LWRlZmF1bHQnPlVudGl0bGVkPC9yZGY6bGk+PC9yZGY6QWx0Pjwv\n" +
                "ZGM6dGl0bGU+PC9yZGY6RGVzY3JpcHRpb24+CjwvcmRmOlJERj4KPC94OnhtcG1ldGE+CiAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\n" +
                "ICAgICAgICAgICAgICAgICAgICAgICAgICAKPD94cGFja2V0IGVuZD0ndyc/PgplbmRzdHJlYW0K\n" +
                "ZW5kb2JqCjIgMCBvYmoKPDwvUHJvZHVjZXIoR1BMIEdob3N0c2NyaXB0IDguNzApCi9DcmVhdGlv\n" +
                "bkRhdGUoRDoyMDE3MDgzMDEwMzQyMCswMicwMCcpCi9Nb2REYXRlKEQ6MjAxNzA4MzAxMDM0MjAr\n" +
                "MDInMDAnKT4+ZW5kb2JqCnhyZWYKMCAyMQowMDAwMDAwMDAwIDY1NTM1IGYgCjAwMDAwMDI2NTYg\n" +
                "MDAwMDAgbiAKMDAwMDAwNDY4MSAwMDAwMCBuIAowMDAwMDAyNTkwIDAwMDAwIG4gCjAwMDAwMDIy\n" +
                "NTYgMDAwMDAgbiAKMDAwMDAwMDAxNSAwMDAwMCBuIAowMDAwMDAxMTE0IDAwMDAwIG4gCjAwMDAw\n" +
                "MDI3MjEgMDAwMDAgbiAKMDAwMDAwMzE1MiAwMDAwMCBuIAowMDAwMDAzMjIxIDAwMDAwIG4gCjAw\n" +
                "MDAwMDI3NzEgMDAwMDAgbiAKMDAwMDAwMzAxOSAwMDAwMCBuIAowMDAwMDAzMDg1IDAwMDAwIG4g\n" +
                "CjAwMDAwMDI4MTUgMDAwMDAgbiAKMDAwMDAwMjg1NiAwMDAwMCBuIAowMDAwMDAyNDIyIDAwMDAw\n" +
                "IG4gCjAwMDAwMDExMzQgMDAwMDAgbiAKMDAwMDAwMjIzNSAwMDAwMCBuIAowMDAwMDAyOTE3IDAw\n" +
                "MDAwIG4gCjAwMDAwMDI5NTggMDAwMDAgbiAKMDAwMDAwMzI4NSAwMDAwMCBuIAp0cmFpbGVyCjw8\n" +
                "IC9TaXplIDIxIC9Sb290IDEgMCBSIC9JbmZvIDIgMCBSCi9JRCBbPDIxNjNGMkMwQUY1MjhENDNG\n" +
                "QkVGQTQ0RTRBNjdGODFGPjwyMTYzRjJDMEFGNTI4RDQzRkJFRkE0NEU0QTY3RjgxRj5dCj4+CnN0\n" +
                "YXJ0eHJlZgo0ODA0CiUlRU9GCg==";
        CoreUtil.base64(a,"pdf");
    }

}
