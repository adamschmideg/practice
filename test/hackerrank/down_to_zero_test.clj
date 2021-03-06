(ns hackerrank.down-to-zero-test
  (:require [clojure.test :refer :all]
            [hackerrank.down-to-zero :refer :all]))

(deftest greatest-div-test
  (are [n greatest] (is (= (greatest-div n) greatest))
    9 [3]
    8 [4]
    7 []
    12 [4 6]))

(deftest downToZero-test
  (are [n down] (is (= (downToZero n) down))
    2 2
    3 3
    4 3))

(deftest hackerrank.down-to-zero-test
  (are [n down] (is (= (down-to-zero n) down))
                8 [1 2 4 8]
                6 [1 2 3 6]))

(deftest downToZero-test-case-1
    (are [n down] (is (= (naive-down-to-zero n) down))
      393991 8))
;                  966514   8
;                  812849   10
;                  808707   8
;                  360422   11
;                  691410   9
;                  691343   11
;                  551065   9
;                  432560   9
;                  192658   10
;                  554548   10
;                  27978   9
;                  951717   10
;                  663795   7
;                  315528   9
;                  522506   9
;                  300432   9
;                  412509   8
;                  109052   9
;                  614346   8
;                  589115   8
;                  301840   7
;                  7273   9
;                  193764   8
;                  702818   10
;                  639354   8
;                  584658   7
;                  208828   8
;                  255463   8
;                  506460   7
;                  471454   8
;                  554516   9
;                  739987   9
;                  303876   7
;                  813024   9
;                  118681   8
;                  708473   9
;                  616288   10
;                  962466   9
;                  55094   8
;                  599778   7
;                  385504   9
;                  428443   8
;                  646717   9
;                  572077   8
;                  463452   9
;                  750219   10
;                  725457   8
;                  672957   9
;                  750371   8
;                  542716   8
;                  87017   8
;                  743756   10
;                  293742   10
;                  301031   11
;                  939025   10
;                  503398   9
;                  334595   9
;                  209039   10
;                  191818   9
;                  158563   9
;                  617470   9
;                  118260   7
;                  176581   8
;                  966721   8
;                  48924   7
;                  235330   8
;                  200174   10
;                  992221   8
;                  411098   11
;                  559560   9
;                  117381   9
;                  814728   9
;                  795418   9
;                  309832   10
;                  943111   8
;                  775314   9
;                  875208   10
;                  168234   9
;                  933574   9
;                  444474   9
;                  995856   9
;                  687362   9
;                  543687   9
;                  761831   9
;                  952514   9
;                  970724   10
;                  611269   8
;                  237583   9
;                  88891   10
;                  708888   8
;                  387629   8
;                  407891   9
;                  393991   8
;                  577592   8))



(run-tests)
