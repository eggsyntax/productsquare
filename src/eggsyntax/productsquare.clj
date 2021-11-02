(ns eggsyntax.productsquare
  (:refer-clojure :exclude [==])
  (:require [clojure.core.logic :as cl :refer [fresh == run*]])
  (:require [clojure.core.logic.fd :as fd]) ; finite domain
  (:gen-class))

(defn -main
  "Run a magic-triangle-ish sort of thing"
  [& _]
  (println
   (run* [q]
     (fresh [a1 a2 a3 a4 a5 a6 a7 a8 a9]
       ;; Declare ranges for all values
       (fd/in a1 (fd/interval 1 1296))
       (fd/in a2 (fd/interval 1 1296))
       (fd/in a3 (fd/interval 1 1296))
       (fd/in a4 (fd/interval 1 1296))
       (fd/in a5 (fd/interval 1 1296))
       (fd/in a6 (fd/interval 1 1296))
       (fd/in a7 (fd/interval 1 1296))
       (fd/in a8 (fd/interval 1 1296))
       (fd/in a9 (fd/interval 1 1296))

       ;; Set constraints
       (fd/eq
        (= a1 60)
        (= a4 36)
        (= a6 625)
        (= a9 1296)
        (= (* a1 a1) (* a3 a4))
        (= (* a2 a2) (* a4 a5))
        (= (* a3 a3) (* a6 a7))
        (= (* a4 a4) (* a7 a8))
        (= (* a5 a5) (* a8 a9)))
       (== q [a1 a2 a3 a4 a5 a6 a7 a8 a9])))))
