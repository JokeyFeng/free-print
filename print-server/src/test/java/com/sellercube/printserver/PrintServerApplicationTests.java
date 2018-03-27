package com.sellercube.printserver;

import com.sellercube.printserver.utils.FileUtil;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class PrintServerApplicationTests {

	@Test
	public void contextLoads() throws Exception {
	    String var="iVBORw0KGgoAAAANSUhEUgAAAyAAAASwAQAAAAAryhMIAAAkbklEQVR42u3d32--su--j2L0YcLIKxAQwzA36IuEKPBsEyLwV4--jiahao--sXG1cVUdyiQYEg--jiahao--9in3ngwqfVQ9K7dwcVKWK1IwYGZAAMTt--su--tQG50r--su--gl56EvQNBk5WgzvAgOzTy2Cze5Qy6lYINkMtbrJHGbOnNPvIeWxZ2x5JVtkZr1HuzY0Gtsfk--jiahao--f74xySQ0ksh4f0miP6a4iYN1Xc1u0zfzm24miVSRHRWaUgEeNVZCccw3cqOCpIOlP7XjiICYnUaYjia--jiahao--cgYSGO1pnkN9D5iASIggsJQpWOG5rN6YgzDtw9dBYZrozGMXs--jiahao--bNoUPX2OX0VoNRyvBvHoc0PXGa2X3FCrxpg9moaMvSN09jc4ag7GhMXeqkdRGJ9F2vXx6jiOE4SMq--su--1Qr8YRc--jiahao--ZDvPjDMEWIE8LPOh8hE4R8yJHHFyDOEC2dRUa--su--ftxiY08HxBufRYzwBTImY--su--zh0LgX--su----jiahao--6cqJsgoTN86yzi9GO--su--ZnAkBmR4ZuBVv8CRUE--jiahao--QwcOh0b1DpiHmluIMv--su----su--WWcSNA8146unO2Hn09OgM0gEkSBBJJ--jiahao--NgghjTEP18BGKra4SejsaOE55FfB7CL5D4aJMj1Ji2u7zzkThFams3AOmeQUgdkjHdXXzgvwhxneEPvelI403FCU30KkIhulhMeihFvO8Yzo0LkNA7ugCpMv88JAlhFuMXyA1dvwgJzkW6zRh2kuetw5foHjXOR2LPSZPRszhC2NQ8CffOQ1bioGZ4w3fPRxgvKyweJQiUFc--su--tXoz42vbDs8kIBbLKPH9LPR--jiahao--ROIILjqdLq1AgPdc07AuQGLfPQ6wYt5gXRVOQfoIoCZKWejYdmfbgO5Bk3RlD--jiahao--IgXhfgxeVjoVb3QZ72atFGRskB66--jiahao--Sh3KtAZzN6mrSxdIyMJx8LQWxAsHfXDbu6t2eErjfjRMIlVclBNTXp8MzqMV1XpiLOAXlIvIfQ2ZB3ZIThzEhUAWRNSTo8K--su--RYrVr4IgQ6m--jiahao--MN50DeDzyv--jiahao--9Z6MGb09j5d8VitNZqOxCkCbWk--jiahao--BPbs0VurozEvKrTpMT6PmIb0scSRh3MjLhTW79--jiahao--JJ4jD1mMyPYQbEh--su--4FJHqMw--su--8--jiahao--x4DpM7GYzYmdOXv2ep4enThNISPNhsIkA11VmT9NMIKJrtxAcLKSTKmiOGjuZB--su--U--jiahao--e5FMascNcoXIRAdDEv6Wx8TNg8yAfDegd--jiahao--tDtiq9SQx70LQ5gjNyCEH8yJPH4ccsQOaJMa5RkQC5Cj2REqeSFHILqYE3KkOp4eXd56irgO4mVldsTlyJgj0G44ckEI944RU4cCWZ8ZaYXeBKGGQ5tdo9acjkRxiqSlfg4ksL3--su----jiahao--08xZDxl9--jiahao--nKXahdeNHLOUK3kDca4cJ4TAqSBwVSr8qLRxo6IFRNEWvAdGd6qTdvxLqJemqfIjtAD6QNFGGZKb2lQjjWVVNTF7IwXR0niIyVFFF7DZnKvSU5HFcVs1JYBALzLj1mHq2OAitQIR1de52RpkfwOFwbO3i8ECQOE6R1Z2z11V0o9k6ZEeIRMg7XR3xGfD4yoDUYaG9MiG73YSGu9oNQcR5HDJ6dRbDLEdJ--jiahao--gaCDY2Qlno6YtCYlCEZKx29oSj8Yyt5D36hBNz6DEC9BoJZOEPgjYQmyCts5rXZprW7LgLKFR3u3Sw--su--Wu--su--X--jiahao--h4--jiahao--b4b0HtVr94CxC0THyfv--su--GLl9bxYwij8CMHRCiT0Fq1W7bgIlKND6COf3qw--su--GHHz4m4T2vWh1Xz0ZXmyO9JY68f--jiahao--M7EF06hHABoosjpqZMyXi92jV0--jiahao--tb7j9lDliAHHz6ERszWz0VgjfwSYnDksLekJgjamYIYpGusUu--jiahao----su----su--47dtUsPUoR9XqV--su--dR7iMP3F7gLECB34I8MeLDb57mKjaUh8ZKzygacVGPg7HDlCuIWNixBajw9W--su--3LTCG0dBg6ia0Sc1diZMh9OET1BqrcTZP0fvQIhmF2EQAiniDcJ4Zg4F4TwCcLujQ--jiahao--G23fHa--su--e8Q0LoRVtCW--jiahao--MJ4jrrCYKJsz6eBXkI0bW2NK7eczAsm--su--SLkLU4SJFwb53BjJAQ4qwFDhlPQ24WTyHV73GER9c0RILo4gXy3p01mN6FkwJJIEqnF0iq3yy2TxD94eete--su--e--jiahao--ENmhKEXGPoSw1Vuibb2mmmhaqa--su--dGUIyAjLmyOpvEgSS8Vzksgc6K3eGrQQZ7dVLD1a6m61fdnlZ0c8rK5dFzPBzaZwUSI0XyFqxXatNLZAxNTQ5PgZJYVbkMPxcHqelHgoYMZZoTbemlfqYtpc5Agv1--jiahao--4DImRwXHpGW--jiahao--2zEanrynQRnggzwe--jiahao--EY5hoThGSCfPh5k40--su--hAlNipxzMOn8PJHH6IF--jiahao--V--jiahao--rprAdTyDDSnTAmqsX6AT6L--su--PqPTRT--jiahao--mundJbys--su--TWhP5x1LjxBEEc8DxCYgakFJp--jiahao--HxLShwipGv1f8z0vLMqEbs05T76gP0F3m2VBcoT--jiahao--MGYpDwlZodXA--jiahao--4j4B5GB4p3q0AhV--su--RqR9R91FS8yDZQrmCOUIzO5bt6LzkGboAeI8uLM--jiahao--bM6OGKspEjLnc2OshwRmJPCzSPsipKvcuBQyNP7--jiahao--j8bn--jiahao--uP3HGLHCNYogwuQezfmRW7svpUgJjWw4esw7cEqII8vQMphgpA5kO98--su--3uwqGN32wZhAYJyjl2o--su--I8fn4--su--AFE5fD--jiahao--0ECedGKEeYAwgLg2lIywOktu7a1aMmwfMhLEWwAQhFLHSnIiogUkOxl5abRJ4d--jiahao--cvNHz6cIGMdEOKxEGY9m987D2kjjpC6s6c1SWFWpD1B3JcQh7TPQ04dOJ--jiahao--naUEypojHYE4cOqEDaxBYhdDWcIFIa4LY7C4FJNABwZ5B1y5EqD4XIo3XhtsPpZ5mnCqQyzKTw8pFiDEXIk--jiahao--QmjHgpR7DR0w1me1ciHzpz--su--0KRCACEYhA--su--pyIyXsVnz2cXksT3WVW7GvIWhCipwg5fWArQi4rxH5FLSwGcVCKvHTYNPDeZ6sj9jN3dUGIkyLx6QNbofs--jiahao--bQ4YzFsXi4xOHw5yQ0BgIbk4RPnW6HENjVm3QcpLNe2vP23oHgPk19R4sCikVpB8GGJAthpf--su--3plWe5tIY--jiahao--t02ZMjeUFIWZ1XHpwu--jiahao--IBcnv1H4N7RysP684EYVpz--jiahao--rxraDjsMCro--jiahao----su--zkwRcgHRZUj--jiahao--oHISB1--su--SfhwbDZNZItWYFV09F0ROKIuVVA--jiahao----su--zw7hcgXaNQ9cIUId9IkAZHmAzI9IGnrU1AtDsMHYy8iw6WpEjtn6dI3K3jf5sgW443lNhPLkbaHNFXmXoQexcdLEkHvjpOkBEg4w8TpO64gMSzITcOyAxIZZyMSTzu1lePkfCoRd--jiahao--N4--su--gLkfGMyL2g--jiahao--qB--jiahao--z8PB3durPwnvHTUf1lGw16KrcYynlxVY7ABijdkqR--jiahao--IvRApVP7ynEsXc2vpGeG--jiahao--52dtAUYUaCuyv6QUyDeFeVADki6PLOVqtjsIuouqvGvjDsKs1P912cJUadhzT6aU--jiahao--DeFoq7DOEXXupjXLamgSwnSVrfPdNZ4buTcTkgw8W2VVjoy--jiahao--aHd5r56GMdnMiM4RPMPAH706aodzIbVy--su--MUZ7zxsXmYikY5J9w7Ty6MZ8uQhuRQiDWXTgAKpl6BAZoXIHBlMSv0FATlBcph3OUcoB8Qr5IEc5oHgPBCSA--su--IwB8S--jiahao--mwPiac3skZ4mZ49EhiXWjAIRyJ8diaQsH3KOSA4PgcyJmMqA6gHjUwl38qLP6RdnhRTShkk--su--uiJitlF--su--OkJk0pAZvRpCmKYjdzqCJbIlMapeDaE6egVJ9s0LJMJRdHXEcC5CRrgxwAZRroYQw7btAaYo--jiahao--sD4pqrpd7--su--LENFL7WoN3dUHbERwQAzy3U81veMrA9y--su--HMI82zYbWPG--su--Vnvja8toSWEoUt--jiahao--oVRvKj5FpQOC5VCff9b--jiahao--OJF8xG53LI9JaVOgVazclBVVUhnxF0uAVU5X0FMG3fUmVNhRpTbos4qKltajv7tZuDixU0RkaWMvazahvqUvHSDDoL1cMe2lt69KIppUGA2tXWwlctWIw1O8j7VuDgb2noWMkcO2qsayV8OURvRSMbLeyHbh7VUDcAGkFeGVPB2QEyGgECDbg6y6N--su--Go2xGzXLo--su--Yn9bOQeTTSCQDIrUujUAyHiM--su--BuSDY--jiahao--SbE4SM--jiahao--lT3JeCXWu1LIzp6gcBO--jiahao--aA1QdZSZES2IRkTpNqgl0WgQEbtJLqsFwiPrrU0ukZ4G8pKgDmyRS8bXcw0IiPJE6sHiM8RSBetutW37SU9ikZQIF1y291b22ZLa5dEfFigJBmvHHKEGDzjOVKASqBjKYikFEky--su--lJIUs6NpHadIJGKtNqaAjXNIHKA5QSxAYGvuzTCkirsDgCJOEJ0QGoIqjO034AqzKbfdu3dN6EKXxo5fgS8f2Q9W--jiahao--G9YnAdEMp7bOFaIHwCoWY9JmLCLRCBCEQgOSKhmwPy6FkOyP3nAnndkFwGPgxzQDASZWWukb8uiCTngHh5bMk4D--jiahao--R5Hgj9QR7R5VyXZPTVHBBnnAOixzkgxvPrguSyu3IZ--jiahao--FxC--jiahao--BouHTBTsE7aKot0m6GoMHnRRCcnhxaA0EKESEthPZUj8jGiLAB50X4jIvsqbhTgx3JEWiTy6HhLfLIdWFEjYJYFyCi98yNmdn8ByJNjpEe2XZcjap8j5BgJFoA8PUZMjF3X3x4xFNh9jqi2VisBEi1w4PcxZhyh--jiahao--sg20YhWC7ZWlQDxlSsL1jHyM458kCISIGvy3vIaR3pXR2CAJ4EEiDVBNI7cerDUiGDgXevqO2vnFKLeTRB--jiahao--xoTejB4sbUUQwtYCkOcnCFUrKaIDsoIffG8b8kS1F5nxgKCXkA--su----jiahao--NUf0BSD6KYTUqmcQGy0AeesUgtvSN0cUvYzYC0Bun0IijkAypufj8OPHI0CsBSCNFwjZ9qlU4mWFRxfZinw--su--ghB2FxBdBjpBBoykBZKf9Gvc8n0MSLCAPDEGLxDZV0ha6iUo9VgGBDJ--jiahao--sICMN041rZ4yaVomNC1SGEQEkJG--su--SIQpgKTtt8--su--brzqIKFThaJFVONMZZB7IW3kgt--su--NAGnkgRh6Hol4kY6YIuy5ILsl4qOSA--su--M93c0DazwXyuiG5DHxfuS7JeD8P5JcCEUhmD1O--jiahao--Lslo5YG8OFiQ6WMnD--jiahao--T5dRn4vpgSfTWRXM6f3M--su--j1Maj8Loko1m4NrVLIHM9AnF2bo6Hn8cBnG4eZcXIozMa710XRM8D6eZxzd3hU3Gl2uuGiCvV5muMxwhO3ssSM--su--b0KT8tpB8yqkbGDkNz3dz2lUdsB1HNOLlSzVcnSMhvqdfWJYMoPSRfDRnbga--su--qJ1eq9ZQJ4rocqUk6LvQ0iSJyNaSn6CfJ6FqnkVqtquOBtbzWQvgKSGAHVh--jiahao--x9vFlPnb--su--JaTaRqORfbfVuBIS2sA4rHU8q7fDu3oH--su--5giWY4MrFUNPUG2UHQFxOWIzZrHl14h9mMk4a9jRZZ9HWtr8NLItsmdKyPMZu8--jiahao--f4GYqtQoRQVZ7iG8lyAuIu--jiahao--gT6--jiahao--G7LyMWMuVRiPqu647QQagGVdCbIgu5p5GbLvawIOB69o2fsCRvm9EDD24GuIjl33j2SkEN3AwOkF2eshnaO9qCFZdFoWnEDNFTBV--su--yhHLRYMrI0xxT5KRI9LLiGrbfYa0KyL900ho7y29QKI1plNk2xZDknolxA5OIfDHvepkTBiOqgYigCgLRvoJkkSXgzGUFSj--jiahao--e--jiahao--oVEatvnUYsy95ba--jiahao--AkT1RAoEAa1jK6Wqm3--jiahao--1b--su--9JhAqd--jiahao--DgY8Kh4eQg4SXehlKvXElxOspPcU7QaBp8ejCyuGhDwg0rUj2q1dEXF9Nm--jiahao--FJ--jiahao--7V31zBFgwFUYd5--jiahao--IzlqXRXBOkZ2xjPIZDiyRpJ3InAyRoK0lmSLJHeh1K8Dwu9Cmd71UBz2EIhAZkXiAVNwCzpkTzmEygmLLIIWjox77UKkGVTuKSYgvi5jdfGIWZX95QSRDKZC542UhSPBXnU72NPJFrMrOlVdbW27v3AkRNVt19NJgy3XdKK6ldbtYOGIi0qYLxoY02o6VmGRlSVCYeoQ27DIMqYitMBv--su--2EzWBj3X3kjqNkQi--jiahao--rEeAYIZmeQ3lpRZuaG8UtWOCK1d--su--SDf3h--jiahao--8PCJMTtiJ4iNC0T3DX4tco--jiahao--dGfhHP6eM3X9y--su--2--su--Ye91nnzzT--su--9vHz3--su--xyaP7cyDLJdy3bCwTw--jiahao--czZfuQnbmG99FHCfLob1j7--su--jufsR--su--818--jiahao--et--jiahao--8b8yBmCfuKjbcAmWyJMg359xPk382N9Eo4AgRjPp58TAz1POT--jiahao----su--Sef--su--E5t33--su--7D5dBBiWMv5sg9KbOo6uNpmxJ93dhCxD17RSZZ--jiahao--BZCcO6--jiahao--xTSOjMJfvSzYoGZfu2zsfzJ2--su----su--09G--su----su--D0cal0JojSN3W40zSO--su--dZEv--jiahao--4emz1uDtPzxLEUOfA9GgrMDvj0e0BmMCZWXrzK--su--4KEV--jiahao--ozxrsxNkrhCubvcB2R6xCke0c--jiahao--6c9uivEuTjpynyd3MjntmSfeRQecTfpNHmpb4wJRk--su--ip--jiahao--16dP--su--MEF--jiahao--MAfimu2CjxAtjNikafmFKdH1Ufy0--su--cun--su----jiahao--LZ333EM96bB--jiahao--Ht10DMGrFJ--jiahao--52K--su--PxP4XsfP9t7591fd5--su--NV7tc9mItMfXx6P8VIRn9d56rhYDcUN--su--9ja7MV4XTt2ebY3349DLtN2kUOsvoIZ2sV--jiahao--Z6g7PXFUluzU9YtoiYcH9Fkbd--su--S7NH6p89zx75j9cG--jiahao--U--jiahao----su--f3Y--su--DyT7LfnbXJAn7--jiahao--SQJ29fG--jiahao--SnP70uiJcH8uRR9skompZABPJVQgp4vmUDUc2NLWVO5L2n85Wu5--jiahao--P7T--jiahao--4bcyLtJ4--su--mQ57df--su--Ioc--jiahao--T5ZZBHn82PvDc38iT7LXlvbsR8e--jiahao--6BL8y--su--Jb4xL2JcYnex1xO5RJ68psi8ZeXpZRD83lwIFMi32bzJKJrWzEi2b0YEDyUvRAy8QATy2iCmtFkfHGADK91G0QjjuFuPWRjjW3HsxLRtdDrdthEPN0pK7JeK7fKuwnaVAa3HHVxmTjjkL5iycxAKRCBfeoRISeL5vFWdRfxNzcCbMm6X5KHcgf--su--9cujgJi22ixuoc2BqyC9ubJTNYqMtw08zN--jiahao--D1st8oD3x5V9psoz8HglgokNcN6WU58OnJ75wQ77xkHN4yEaSfrxm--jiahao--Vt9tmsivd6WyE--jiahao--Jiqe4jazCUQ6wMm--su--ttqY06TsfUSsU6lYfN7gaiZctUckawwnoZI5Lsy0x6E--su--UkCUvZIT2pLUmo9zXajLNDTKkKCBu2V8fZIZK0xpFQV8LMEEmOSgninNywcvFIIXpDNQHxHnlnkrE8lGNa0jSjq3Q6A7a--su--iSzoWMjqGrtyp--jiahao--M4Hf--jiahao--WM8CK2exuyqbR6RalW50Bbci7G1qxiU--jiahao--VlQKW1B5kvJteU58FUgBGQrysBCeXqGSFeGx8cmFHdkhMWPbIsyy3RIHyyMdknOWYHCPhyQVQC0dogUUQwjxP7ON--su--13nStGS--su--oXSLxZK0qZjljrlR3zWwvF8qbsj7hmmEw41y14i7klZEcccxS8ZwsyTdwsYQZnsdapwgcvRGYZLxf--su--pBRgiTpNJx7frjT7ND1tIqXB--su----su--8e2sEFNqceQxGcfZbUlPotKb--su--OgQlv7kZIVE--su--NJl--su--rbbRGplE13woOqZd19cPHLBIsjflIwDrAx2i1I57spOGJqleuxvbGgNqVE--jiahao--6GCpbpbazV3ZLBblrrKPOuYtv90oNaRbQ--su--g9BtcWIUYOyDg5LG9ki4SPckDS0zFZI--su--j2J--su--8ryhp59vEnR09eRQZdxS--su--vF2VajrFx4JeU5NgAb1pgdBz42--su--quMsAbJdRto13DiR2Y--jiahao--DXqMevWYaG08Woy--su--v4vfvnJo7czRp58BMgPrgMSfpTD7hp--su--9PHDzBH8F8Gnj7YyRqYc78oD8cshbRTRblsOaRO6lFanG--jiahao--UYuhfV5H3Z3IDmheJwv3iL7fKv2JXKncH--jiahao--5PiC3K0zgQjkq4AMG5pU7rZluqn4suUr3U2phPblfdQtybR--jiahao--QDXp1oGJcLvuF4--jiahao--72EZxo9Rkgy40MTkUiEC--jiahao--Ekhb6WDDOqCbRsjMW45--su--y7H8RrmrQEvSQG2Xh00WQo8y4NeRrYOQGvyETZO3NdkZygL5yiO9ly8oQdcSGXTlAVZwY1O61TXMhlbclMqD2DHb7Y26r3TiQeij--jiahao--AAjqzM8PpwAX2Fhxd--su--YLPttQyAC--jiahao--Sogw3YRmpbha0bH6jg--jiahao--OvDlrtbEdb--jiahao--N9qVmV4lxPbbMsoms4YYyiLswyxuWmd--su--sOLhdbEv164noJ--su--XXv04IyQ4hUnKnNL4lKDMEnyBBVghNr7JMkOcniyBY9DQ2GsawqKSXxGweHywwwk7HbEKucq--jiahao--4KVPZ1--jiahao--oH5gYKndCJQ--su--jSOjWcC5AgKyRJFvnVMckOORVdC0aOs--su--3lPMkEUZMtkXNA2LOMEJIihUxDeBpSxu3SpuJQaFxlfk7mFi7JB--su--BqEdpS2emYxQ3Fv7UPCx9NahfLZrmLBvBag5--su--GkR3nFeT4aurcEFLICDH5dUu9yZawLzFCkxIMo69ni6CcEJoivpwZwg9up0h8siXhgY--jiahao--wvI--jiahao--Gxbqp8IMFt7Ac7rel5hCZWvPiFzSY--su--p2HmAlCM0KwJKezCOXlMfkyIkrOCFayQdLfn--jiahao--GkCj99lhWinyBPnmeLKK8gfnNXTnvU0Ah3jRDmcuwgHspmW7GGqIPLoV8q4--jiahao--YuiqnSLSlWx4r9dt1vbBoW1W69uDjmJSSdQeaCnBqT7JBT0ZUdcroKLxKRpFPrk9jNAfnjz3NAnryXM1Km7UZ54NCmiQa7muz4yrBd9tsbRaUrdzodvwxJWI5DKg--jiahao--LDQ3yEQ3rMVb2pVu7xbqP4guQ5zkgp--su--MkM--jiahao--TZ0xyQl2YrX0rE5EvTvJCX5l1ZIfHp2mWiA36SRipt1J14XxlqmoyLhrlZktrlbpPKoa--jiahao--VmvDjuo02--su--A4HMAEcxH6j2Ci2tQ35AoTmgTCBzIO81BmzQp7--jiahao--PAfkycc5I--su--ySY2MXWtYBc--su--YbRWVodHBpowSzvaLhmGWzWKeNW7iobbSVwa5yMBgwv4S6Zb8EyRruK68ges7I019kg0wOqEZpdN3JBjmeC5--su--Jk8yQ03mSGXK6x2eGnJ6tLBZRzkUGDi5jeXAASTc09qVNFHZl2qQbyq7WUKyu1pA2ik1aam--su--UaT3NUSO5ElPpGt06lq38EXwaOTUm2SGnomvBSOHcPFkwIp8gYR7IbzNCJkeJ0iMSn--jiahao--WB--su--D6L98U--jiahao--fXgwyRM7D2SUDZIesj3ujCxDhL4871o84h--su--foCRLJMoTUU--su--WJ4tHJudPTh8XzhahWSHs9JmgLzeSXl5gXAPk9AnmPJDM8uQ0klmeJGdoJlcW0DwQliHy6lGia4Dg5zkgT9--su--LBHn5gqUnv8gD--jiahao--TgP5LMckKd--su--yAGJ4xyQjPLkZSTMA--su--ltHshneSAZrU9eyRM7D2SUB8KuS558eZFXH34eb--jiahao--0e57ElVNx78LVD--su--EIeW--su--JcIPM8AhHCAhGIQAQiEIEIRCACEYhABCIQgQhEIAIRiEAEIhCBCEQgAhGIQF5XRLwxp4gugQgkawTtwKcdZh2--su--N042CP--jiahao--XXPxdctTsEKpJ2SNEWzNgc8hWYGWIVFoJ0gjc7BAMCG4pmLkZRhdGxPArGSMjQHpLCrY--jiahao--0LNEsNFXES70UHZIgCJmWQjLvQxD2EU--jiahao--s12Et--su--pWlsggQbCbYQjbqJ89YipWHoiSA1JUeXQRHGaIMA0xyBOyHdhZIpLRU1G2pZ5VJMNHiBYilC2CDZRx--jiahao--xVTIoEIRCALQySJKqzDfJimWixiRI8MRhUqId--su--A6IoIbt1UD4nHESxTyTD1YwSmXvwVZCJfvSqydlMxWwkSSUTS--jiahao--T9MUZjPsG6qLJIAkdSX3uf6cshKf--jiahao--kEqfF--su--55oiksL4K4CYhasjgbbGm23PjxpVTVVhJFiPRTpMXPyopVNV2ekvAll34NnhADfaFWQxkiJqnw0wIMhSBldF--su--sdKoPp8p--jiahao--8kiG7xO1--jiahao--azK--jiahao--hF4h6ZeS--su--rAQ7CaJwBAESTZDgGPEWgPTN2HmBQPz6FvxNrwbTYkC--jiahao--BQi7OnJT8ZsOf3fQFFHYwKJvsB9NEKkNyOHVEZW8qXAkikgVgokFL5AowpIO8bZz9d3FtARBSTLCrO6JRW6ypQSRAJFUcuU8--jiahao--d--jiahao--ArECaE5SUFT6rSxH1EMoKrkJZIVfO--jiahao--AeArELBIvoJgrdoRVc6vHa1F4Xc5QjWj3fXBJFk2F2MqYvYXYCYdzhi8LLCo4tZSQiYMpQVgy2rytWjCxB--su--nCADvNZOIilFejKEsM6W0Q7UywU1LVjAw3irDIqhNYgg1aNbrA--su--z7iW9D--jiahao--1lQUjEThBfKkGhH3y5Ef0ECeCVKke8BSNLJ4jX569ALPfVBSKH--jiahao--GZ7iR--su--pTCcS0LT4KxW0oywsugYsbb--su--KMZK03--jiahao--SVncMFIlJD0vhEIkVMJXmlJilXnkicQtIp0QmiJq8YMCVaIJJO7tArkzsGkztlcch509TklStPU8XSQSACEYhABCIQgQhEIK8hQhR--jiahao--DOI--jiahao--wyNmyhjBf7Dc5gekrOQJgadXmgqfIFRPEV--jiahao--B--su--1RGEyR5EinwRFkIAovcaABIrwD--su--KYzw4xJK8sQvwJPClZGCnyCjAJCdw51D--jiahao--JEYUYUqyZNegV5tNZci3--su--70GGF9a2ANdnaYnyA7fXhyeEgVa7AIxIyKb--su--Bb6Vocsfqsh4hC--jiahao--M--su--uof6ALAbRpJtFmSM2R1if--su--QphC4MITyyWPFkE8kaKqH14QGA9SBAYigcJ0u9fGVl5UKm1amrgQsDyECYq--jiahao--wSNrJFlyvDkR--su--B0ASEMiE5qKEEiNVIhfikKrMDqyfDEVALrame0jxE1RYiebIkyQfwEKQSL2JL1I00--jiahao--RpIx6cPPdi3Xwt--su--iiOwuYkzW9pDUqiEYeGIk0QULemRbtpU82Tm0FxFdgPSqCYITxBokGwDDzp9YA1NeDIIr5yHW4eKQahdRQFx7guwcThCoLxT1DxeDaKiWIhGbFMi01CdP4JO1gAJZ1SpStYgsFRBe6v0XCI9l--jiahao--JO1gFJfq2lSrYhsBAjPk0jJoGnVashkEyRpv2iCQPulC2q--su--YkokEIEI5AoPKEId--su--ili6Um9TBCf--su--2sQ--jiahao--JQpAlN0yYDu4DPYoswQmUj8HGUvS8TkiJkgcmZIp4dLqNNjJqPZIYUerqJCj0pZIooPiOITmCxmjuBMEZcj8OlNhrNDGEfg0wbD--su--ypDhJR05sc--jiahao--izJEDiFP2OEzn--su--nZlRXWgbLCzxxmi--su--Cfy5HDDBFeIBkvkP3sEFqAMaEc2ckOIQrULsKvqFOyQ7AKeYLVjBEUtVVovz5Vs0MijkQcSd4VMKMerwPi69kiPQOQnpExwjjCskU6LKqqnYwRmUGeQCfxs5x3SRKW--jiahao--PGNzBE9YwRGgl--jiahao--rmzlCpXb2CG9bGY--jiahao--JWGkJRCACEYhABCIQgQhEIAIRiEAEIhCBCGQ2pM--su--UyNhh--su--AMN--jiahao--LWd4Q5BPsMKpjLzmcvsQcgilSlYxxLWD6nKRixgyIJvkfhXzoKYpODr8OPgA--su--UMrDJPxio8SRBTB8S8Awi--su--7QuWfFVqKSkisx6SIqVnzIJIrUJPkxh8UGTqkcKO4Fv5k4hwxGIqIL5KZF9NkEaB--su--wtOmn4L--su--8pZkEpj4C6vGa62RtCePnLZ3trIhSfMJwZbRgpVKyvwmye34hn1dytrA3bIdoi2xqxlfdDfQzMgtNYY2XdbHMEIcaQ7QXqAIA0Qbf0YGbgPaisj1gGk0mL2nh4EaDZkhXEEPrYQQkHAKq3b8K0jGCxAKgpZ1jEgye2RghSRWYHfwWw--jiahao--hNmEI3deQtA--jiahao----jiahao--S4gboJ8qidIHxDYxpVj5Nvw5TMi6gR55zTiqz--su--DBbb3L1289y0MgZQgbmBXjIBt02--jiahao--PAHEr8sil--jiahao--kzITYWpmCNGgtBqiigYJyGM9yRi9NQEsSC6jAIbpUivAtEVzYRUbhYoipJxQcsnSOBiDIPP3NGeBL--jiahao--0nSB2pHcY5Am5HVTWDL--su--VwCiaLU9uDnjeJoh5grAAM8y3JNirVA3mpshkS3Dg8ts--su--IbI125Ywc2VE9EGK9F5F9jhSe4EgPiaDBEGS4SKy7dJZBp79amWEjX6KDF5FEHLd00gaXaNRYKMfGbYNu22m6GJ0ZRQxK0XYOUjvn51FIslUyJyID4P5KhIEGJ8g7gmycoLcTX--jiahao--dGaKr2hzx8g1lBYoIlBVaS8rKCVJIEF5WqH6CfK3B5kAqjaAPo5cgyyfIyMVkGwokhBSkRGCnSFogeamv8AK5NmOBZBIp9JYhHqF2I9OAUl--jiahao--blHpMjvtJa1LqqZ6Weo5o8jylXiKKuSQZSdMyedNCadNSMS2wnsERzKLkXmVUj5BJlGMEvoV--su--5YztlyMn7Rcl7ZcgnNy1hrdfiDOdt1--jiahao--qv9J--jiahao--d2Ztv2ceZ3YyhPLCZyvOmVfixSNnb3g3WjzinXll--su--CVFwhleERPuLyvib--jiahao--PCqFega8hcI8uK31YCUy90MOr0iNrzl3V--su--WSHbmP--su--tlp5--jiahao--AfTiiqQju0fkXkClIJLIdq8wwmRZIiou7CkCEYhABCIQgQhEIAIRiEAEIhCBCEQgAhGIQAQiEIEIRCACEYhABCIQgQhEIAIRiEAEIhCBCEQgAhGIQAQiEIEIRCACEYhABCIQgQhEIAIRiEAEIhCBCEQgAhGIQAQiEIEIRCACEYhABCKQry4ibgsoEIEIRCACEYhABCIQgQhEIAIRiEAEIhCBCEQgAhGIQAQiEIFk--jiahao----su--j--su--yoNlKQeGG4IAAAAASUVORK5CYII=";
        InputStream inputStream = new ByteArrayInputStream(Base64.decodeBase64(var));
        //PrintUtil.printImage("D:/a.jpeg");
        String aaa="/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDABQODxIPDRQSEBIXFRQYHjIhHhwcHj0sLiQySUBMS0dA\n" +
                "RkVQWnNiUFVtVkVGZIhlbXd7gYKBTmCNl4x9lnN+gXz/2wBDARUXFx4aHjshITt8U0ZTfHx8fHx8\n" +
                "fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHx8fHz/wAARCAFaAfQDASIA\n" +
                "AhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA\n" +
                "AAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3\n" +
                "ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm\n" +
                "p6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA\n" +
                "AwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx\n" +
                "BhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK\n" +
                "U1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3\n" +
                "uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDjKKKK\n" +
                "ACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA\n" +
                "KKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAo\n" +
                "oooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACii\n" +
                "igAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKK\n" +
                "ACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA\n" +
                "KKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAo\n" +
                "oooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACii\n" +
                "igAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKK\n" +
                "ACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA\n" +
                "KKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAo\n" +
                "oooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACii\n" +
                "igAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKK\n" +
                "ACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA\n" +
                "KKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAo\n" +
                "oooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACii\n" +
                "igAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKK\n" +
                "ACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA\n" +
                "KKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAo\n" +
                "oooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACii\n" +
                "igAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKK\n" +
                "ACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA\n" +
                "KKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAo\n" +
                "oooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACii\n" +
                "igAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKK\n" +
                "ACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA\n" +
                "KKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAo\n" +
                "oooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACii\n" +
                "igAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKK\n" +
                "ACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA\n" +
                "KKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAo\n" +
                "oooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACii\n" +
                "igAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKK\n" +
                "ACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA\n" +
                "KKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAo\n" +
                "oooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACii\n" +
                "igAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKK\n" +
                "ACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA\n" +
                "KKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAo\n" +
                "oooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACii\n" +
                "igAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKK\n" +
                "ACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA\n" +
                "KKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAo\n" +
                "oooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACii\n" +
                "igAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKK\n" +
                "ACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA\n" +
                "KKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAo\n" +
                "oooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACii\n" +
                "igAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKK\n" +
                "ACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA\n" +
                "KKKKACiiigAooooAKKKKACiiigD/2Q==\n";
        System.out.println(FileUtil.base64ToFile(aaa,"jpg"));
        Thread.sleep(3000);
    }
}
