(ns hackerrank.bigger-is-greater-test
    (:require [clojure.test :refer :all]
              [hackerrank.bigger-is-greater :refer :all]))

(deftest the-test
  (are [?input ?expect] (= (biggerIsGreater ?input) ?expect)
    "ab" "ba"
    "bb" "no answer"))

(run-tests)

