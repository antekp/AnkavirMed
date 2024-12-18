package com.yt.fooddeliveryappui.model

import android.os.Parcelable
import com.yt.fooddeliveryappui.R
import kotlinx.parcelize.Parcelize



val listOfAlergia = listOf(
    Food(
        "Allegra",
        13.99,
        "Odbiór w ciągu 1h",
        "Allegra to lek dostępny bez recepty w postaci tabletek, stosowany w celu zniwelowania objawów alergii, takich jak katar sienny czy zaczerwienienie i łzawienie oczu. Substancją czynną preparatu jest feksofenadyna o działaniu przeciwhistaminowym. Preparat wskazany jest w leczeniu sezonowego alergicznego zapalenia błony śluzowej nosa. Przeznaczony dla młodzieży powyżej 12. roku życia i osób dorosłych.",
        R.drawable.allegra,
        listOf(
            R.drawable.allegra,
            R.drawable.allegraopis
        )
    ),
    Food(
        "Clatra Allergy",
        11.19,
        "Odbiór w ciągu 1h",
        "Clatra Allergy to lek dostępny bez recepty w postaci tabletek o działaniu przeciwalergicznym, który łagodzi objawy alergii, takie jak pokrzywka, katar sienny, czy łzawienie oczu. Substancją czynną preparatu jest bilastyna należąca do grupy leków przeciwhistaminowych. Jej stosowanie pomaga złagodzić objawy uczulenia, np. cieknący katar, obrzęk nosa, zapalenie spojówek, wysypkę i świąd. Preparat przeznaczony jest dla dorosłych i dzieci od 12. roku życia.",
        R.drawable.clatra,
        listOf(
            R.drawable.clatra
        )
    ),
    Food(
        "Amertil Bio",
        7.99,
        "Odbiór w ciągu 1h",
        "Amertil Bio tolek dsotępny bez recepty w postaci tabletek o działaniu przeciwalergicznym. W swoim składzie zawiera cetyryzynę, która wywiera działanie przeciwhistaminowe blokując receptor histaminowy H1. Produkt stosowany jest w celu zniwelowania objawów uczuleniowych, takich jak alergiczny nieżyt błony śluzowej nosa oraz przewlekła pokrzywka idiopatyczna. Wskazany u dorosłych i dzieci po 6. roku życia.\n",
        R.drawable.amertil,
        listOf(
            R.drawable.amertil
        )
    ),
    Food(
        "Alergo Teva",
        5.29,
        "Odbiór w ciągu 1h",
        "Alergo Teva to lek bez recepty w postaci tabletek powlekanych o działaniu przeciwalergicznym. Substancją czynną jest desloratadyna, która jest lekiem przeciwhistaminowym i działa przeciwalergicznie, nie powodując senności. Może być stosowany w łagodzeniu objawów uczulenia, związanej z alergicznym zapaleniem błony śluzowej nosa, takich jak: kichanie, swędzenie nosa, wodnista wydzielina z nosa, oraz swędzenie podniebienia, zaczerwienienie oraz swędzenie czy łzawienie oczu. Dodatkowo wskazaniem jest pokrzywka skóry. Lek przeznaczony do stosowania u dzieci powyżej 12. roku życia oraz u osób dorosłych.",
        R.drawable.alergo,
        listOf(
            R.drawable.alergo,
            R.drawable.alergotyl
        )
    )
)


val listOfWitaminy = listOf(
    Food(
        "Vigantoletten MAX",
        13.99,
        "Odbiór w ciągu 1h",
        "Suplement diety\n" +
                "- Najczęściej wybierana dawka witaminy D1\n" +
                "- Mała, łatwa do połknięcia kapsułka\n" +
                "- Ekspert od witaminy D z 90-letnim doświadczeniem\n" +
                "\n" +
                "1 Preparaty z witaminą D w tabletkach i kapsułkach, sprzedaż ilościowa do pacjenta, IQVIA MAT 08/2020",
        R.drawable.viga,
        listOf(
            R.drawable.viga,
            R.drawable.viga2
        )
    ),
    Food(
        "Witamina C 1000 mg",
        20.19,
        "Odbiór w ciągu 1h",
        "Suplement diety Witamina C 1000 mg w postaci kapsułek jest preparatem o wysokiej zawartości kwasu L-askorbinowego, który stosuje się wspomagająco przy zdrowej diecie w celu pokrycia codziennego zapotrzebowania organizmu na ten związek.",
        R.drawable.witc,
        listOf(
            R.drawable.witc,
        )
    ),
    Food(
        "Amertil Bio",
        8.79,
        "Odbiór w ciągu 1h",
        "Witamina B12 wspomaga:\n" +
                "\n" +
                "prawidłową produkcję krwinek czerwonych\n" +
                "utrzymanie prawidłowego metabolizmu energetycznego\n" +
                "prawidłowe funkcjonowanie układu nerwowego\n" + "\n" +
                "Witamina B12 wspomaga utrzymanie prawidłowego metabolizmu energetycznego, pomaga w prawidłowym funkcjonowaniu układu nerwowego oraz pomaga w utrzymaniu prawidłowego metabolizmu homocysteiny.",
        R.drawable.b12,
        listOf(
            R.drawable.b12
        )
    ),
    Food(
        "Witamina A",
        6.89,
        "Odbiór w ciągu 1h",
        "Witamina A HASCO stosowana jest profilaktycznie w zapobieganiu niedoborom witaminy A.\n" +
                "Witamina A odgrywa istotną rolę w procesie widzenia (zapewnia prawidłowe funkcjonowanie siatkówki), jest niezbędna do wzrostu, regeneracji, różnicowania się komórek, czynności naskórka i nabłonków oraz błon śluzowych. Zwiększa odporność na zakażenia, bierze udział w kostnieniu i tworzeniu struktury kości, w procesie rozmnażania, zapłodnienia i rozwoju zarodkowym.",
        R.drawable.wita,
        listOf(
            R.drawable.wita
        )
    )
)
val listOfSuplementy = listOf(
    Food(
        "Ashwagandha",
        119.99,
        "Odbiór w ciągu 1h",
        "Wyciąg z korzenia ashwagandhy wspiera odporność organizmu na stres, wspomaga koncentrację i procesy zapamiętywania, wpływa na wydolność fizyczną i umysłową oraz wspomaga utrzymanie emocjonalnej stabilności. shop.natu.care",
        R.drawable.ashwa,
        listOf(
            R.drawable.ashwa
        )
    ),
    Food(
        "Omega 3",
        9.79,
        "Odbiór w ciągu 1h",
        "Omega 3 - źródło kwasów tłuszczowych EPA i DHA\n" +
                "\n" +
                "Kwasy tłuszczowe omega-3 są niezbędne zachowania optymalnego samopoczucia i stanu zdrowia. Znajdują się w warstwach tłuszczowych ryb zimnowodnych i skorupiaków, olejach roślinnych i orzechach. Dostarczają one cenny kwas eikozapentaenowy (EPA) i kwas dokozaheksaenowy (DHA), które są najczęściej promowane w kierunku wsparcia prawidłowej pracy serca. Korzystnie wpływa na serce, mózg i naczynia krwionośne. Omega 3 kompleksowo wspiera pracę organizmu. Silnie skoncentrowany olej rybi znajduje się w wygodnych w użyciu kapsułkach żelowych.",
        R.drawable.omega,
        listOf(
            R.drawable.omega,
        )
    ),
    Food(
        "NeoMag Skurcz",
        31.55,
        "Odbiór w ciągu 1h",
        "Suplement diety Neomag skurcz zawiera magnez. Ponadto, składniki NeoMagu skurcz uzupełniają dietę w witaminę B₆ oraz potas. Magnez oraz witamina B₆ przyczyniają się do utrzymania prawidłowego metabolizmu energetycznego. Magnez oraz potas pomagają w prawidłowym funkcjonowaniu mięśni. NeoMag – Więcej niż magnez",
        R.drawable.magnez,
        listOf(
            R.drawable.magnez
        )
    ),
    Food(
        "Potas 320 mg",
        12.69,
        "Odbiór w ciągu 1h",
        "Suplement diety Potas 320 mg przeznaczony jest do uzupełniania zapotrzebowania organizmu na potas, który jest niezbędnym składnikiem mineralnym organizmu.",
        R.drawable.potas,
        listOf(
            R.drawable.potas
        )
    )
)