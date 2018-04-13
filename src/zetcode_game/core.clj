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


(defn draw-donut [^Graphics2D graphics size]
  (doto graphics
    (.setRenderingHints (doto (RenderingHints. RenderingHints/KEY_ANTIALIASING
                                               RenderingHints/VALUE_ANTIALIAS_ON)
                          (.put RenderingHints/KEY_RENDERING
                                RenderingHints/VALUE_RENDER_QUALITY)))
    (.setStroke (BasicStroke. 1))
    (.setColor Color/gray))
  (let [w (.getWidth size)
        h (.getHeight size)
        e (java.awt.geom.Ellipse2D$Double. 0 0 80 130)]
    (for [deg (range 0 360 5)]
      (doto graphics (.draw (doto (AffineTransform/getTranslateInstance (/ w 2)
                                                                        (/ h 2))
                              (.rotate (Math/toRadians deg))
                              (.createTransformedShape e)))))))

(defn panel
  []
  (proxy [JPanel] []
    (paintComponent [graphics]
      (proxy-super paintComponent graphics)
      (draw-donut graphics (proxy-super getSize)))))

(defn frame
  []
  (doto (JFrame.) ; make a new JFrame
    (.setSize 250 200) ; 250 wide, 200 tall
    (.setTitle (str "zetcode game " (int (* 1000000 (rand))))) ; random title string
    (.setDefaultCloseOperation JFrame/DISPOSE_ON_CLOSE) ; just dispose of the frame
    (.setLocationRelativeTo nil) ; center the frame on the screen
    (.add (panel))
    (.setVisible true))) ; make it so
