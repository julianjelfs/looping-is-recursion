(ns looping-is-recursion)

(defn power [base exp]
  (loop [acc 1
         n exp]
    (if (zero? n)
      acc
      (recur (* acc base) (dec n)))))

(defn last-element [a-seq]
  (loop [sq a-seq]
    (cond
      (empty? sq) nil
      (= (count sq) 1) (first sq)
      :else
      (recur (rest sq)))))

(defn seq= [seq1 seq2]
  (loop [s1 seq1
         s2 seq2]
    (cond
      (and (empty? s1) (empty? s2)) true
      (or (empty? s1) (empty? s2)) false
      (= (first s1) (first s2))
      (recur (rest s1) (rest s2))
      :else false)))

(defn find-first-index [pred a-seq]
  (loop [i 0
         sq a-seq]
    (cond
      (empty? sq) nil
      (pred (first sq)) i
      :else
      (recur (inc i) (rest sq))))) 

(defn avg [a-seq]
  (loop [sum 0
         sq a-seq]
    (if (empty? sq)
      (/ sum (count a-seq))
      (recur (+ sum (first sq)) (rest sq)))))

(defn parity [a-seq]
  (let [f (filter #(let [[_ snd] %] (odd? snd)) (frequencies a-seq))]
    (set (map #(first %) f))))

(defn fast-fibo [n]
  (cond
    (zero? n) 0
    (= n 1) 1
    :else
    (loop [i 1
           cur 1
           prev 0]
      (cond 
        (= n i) (+ cur prev)
        :else
        (recur (inc i) prev (+ cur prev))))))

(defn cut-at-repetition [a-seq]
  (loop [result []
         sq a-seq]
    (cond
      (empty? sq) result 
      (contains? (set result) (first sq)) result
      :else
        (recur (conj result (first sq)) (rest sq)))))

