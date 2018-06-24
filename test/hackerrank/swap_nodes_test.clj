(ns hackerrank.swap-nodes-test
  (:require [clojure.test :refer :all]
            [hackerrank.swap-nodes :refer :all]))

(deftest next-path-test
  (are [path next] (is (= (next-path path) next)) ;(str "Got: "(next-path path))))
    [:left :left] [:left :right]
    [:left :right] [:right :left]
    [:right :right] [:right :left :left]))

(deftest next-existing-path-test
  (let [tree {:val 1, :left {:val 2}}])
  (are [path next] (is (= (next-existing-path tree path) next))
    [:left] [:right]
    [:right] [:left :left]
    [:left :right] [:left :right]))

(deftest parse-tree-test)

(run-tests)
