(ns zetcode-game.core
  (:import (javax.swing JFrame
                        JPanel)
           (java.awt BasicStroke
                     Color
                     Dimension
                     Graphics
                     Graphics2D
                     RenderingHints)
           (java.awt.geom AffineTransform
                          Ellipse2D)))


(defn rendering-hints []
  )

(defn panel
  []
  (proxy [JPanel] []
    (paintComponent [graphics]
      (proxy-super paintComponent graphics)
      )))

(defn frame
  []
  (doto (JFrame.) ; make a new JFrame
    (.setSize 250 200) ; 250 wide, 200 tall
    (.setTitle (str "zetcode game " (int (* 1000000 (rand))))) ; random title string
    (.setDefaultCloseOperation JFrame/DISPOSE_ON_CLOSE) ; just dispose of the frame
    (.setLocationRelativeTo nil) ; center the frame on the screen
    (.add (panel))
    (.setVisible true))) ; make it so
