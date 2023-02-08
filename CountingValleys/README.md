**Counting Valleys**

Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details like topography. During his last hike, he took exactly steps. For every step he took, he noted if it was an uphill or![](Aspose.Words.db5dc6b0-4608-495d-8300-a31ce25a9bea.001.png) a downhill step. Gary's hikes start and end at sea level. We define the following terms:

- A mountain is a non-empty sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
  - A valley is a non-empty sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.

Given Gary's sequence of up and down steps during his last hike, find and print the number of valleys he walked through.

**Input Format**

The first line contains an integer, , denoting the number of steps in Gary's hike.![](Aspose.Words.db5dc6b0-4608-495d-8300-a31ce25a9bea.002.png)

The second line contains a single string of characters. Each character is (where U indicates a ![](Aspose.Words.db5dc6b0-4608-495d-8300-a31ce25a9bea.003.png)![](Aspose.Words.db5dc6b0-4608-495d-8300-a31ce25a9bea.004.png)![](Aspose.Words.db5dc6b0-4608-495d-8300-a31ce25a9bea.005.png)step up and D indicates a step down), and the character in the string describes Gary's step during the ![](Aspose.Words.db5dc6b0-4608-495d-8300-a31ce25a9bea.006.png)![](Aspose.Words.db5dc6b0-4608-495d-8300-a31ce25a9bea.007.png)hike.

**Constraints**

` `![](Aspose.Words.db5dc6b0-4608-495d-8300-a31ce25a9bea.008.png)![](Aspose.Words.db5dc6b0-4608-495d-8300-a31ce25a9bea.009.png)

**Output Format**

Print a single integer denoting the number of valleys Gary walked through during his hike. **Sample Input**

8 ![](Aspose.Words.db5dc6b0-4608-495d-8300-a31ce25a9bea.010.png)UDDDUDUU

**Sample Output**

1![](Aspose.Words.db5dc6b0-4608-495d-8300-a31ce25a9bea.011.png)

**Explanation**

If we represent \_ as sea level, a step up as / , and a step down as \ , Gary's hike can be drawn as:![](Aspose.Words.db5dc6b0-4608-495d-8300-a31ce25a9bea.012.png)![](Aspose.Words.db5dc6b0-4608-495d-8300-a31ce25a9bea.013.png)![](Aspose.Words.db5dc6b0-4608-495d-8300-a31ce25a9bea.014.png)

\_/\ \_ \![](Aspose.Words.db5dc6b0-4608-495d-8300-a31ce25a9bea.015.png) /

\/\/

It's clear that there is only one valley there, so we print on a new line.![](Aspose.Words.db5dc6b0-4608-495d-8300-a31ce25a9bea.016.png)