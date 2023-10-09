/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package pl.edu.pw.ee.aisd_lab_0;

/**
 *
 * @author userl
 */
public class BSearch {

    public int search(int[] nums, int toFind) {
        if (nums == null) {
            throw new RuntimeException("Tak nie mozna");
        }
        int result = -1;

        int p = 0;
        int k = nums.length - 1;

        while (p <= k) {
            int middle = p + (k - p) / 2;
            if (nums[middle] < toFind) {
                p = middle;
            } else if (nums[middle] > toFind) {
                k = middle;
            }
                else 
                    return middle;

            }

            return -1;
        }

    }
