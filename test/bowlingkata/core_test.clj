(ns bowlingkata.core-test
  (:require [clojure.test :refer :all]
            [bowlingkata.core :refer :all]))

(deftest ten-nines
  (testing "Ten nines should equal 90"
    (is (= (score "9-9-9-9-9-9-9-9-9-9-") 90))))

(deftest eleven-fives
  (testing "Ten spares (5/5) and a final 5 = 150"
    (is (= (score "5/5/5/5/5/5/5/5/5/5/5") 150))))

(deftest twelve-strikes
  (testing "12 strikes = 300"
    (is (= (score "XXXXXXXXXXXX")))))
