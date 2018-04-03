(ns zetcode-game.core-test
  (:require [clojure.test :refer :all]
            [zetcode-game.core :refer :all])
  (:import (javax.swing JFrame)))

(defn frame
  []
  (doto (JFrame.)
    (.setSize 250 200)
    (.setTitle "zetcode game")
    (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
    (.setLocationRelativeTo nil)
    (.setVisible true)))
