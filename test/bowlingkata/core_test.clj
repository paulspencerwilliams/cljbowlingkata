(ns bowlingkata.core-test
  (:require [clojure.test :refer :all]
            [bowlingkata.core :refer :all]))

(deftest ten-nines
  (testing "Ten nines should equal 90"
    (is (= (score [9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0 9 0]) 90))))
