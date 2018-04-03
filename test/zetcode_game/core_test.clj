(ns zetcode-game.core-test
  (:require [clojure.test :refer :all]
            [zetcode-game.core :refer :all])
  (:import (javax.swing JFrame)))

(defn frame
  []
  (doto (JFrame.) ; make a new JFrame
    (.setSize 250 200) ; 250 wide, 200 tall
    (.setTitle (str "zetcode game " (int (* 1000000 (rand))))) ; random title string
    (.setDefaultCloseOperation JFrame/DISPOSE_ON_CLOSE) ; just dispose of the frame
    (.setLocationRelativeTo nil) ; center the frame on the screen
    (.setVisible true))) ; make it so
