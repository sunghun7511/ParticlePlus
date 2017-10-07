package com.SHGroup.ParticlePlus.Lib;

/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

import java.util.Random;


public final class MathUtils {
	static public final float nanoToSec = 1 / 1000000000f;

	static public final float FLOAT_ROUNDING_ERROR = 0.000001f; 
	static public final float PI = 3.1415927f;
	static public final float PI2 = PI * 2;

	static public final float SQRT_3 = 1.73205f;
	
	static public final float E = 2.7182818f;

	static private final int SIN_BITS = 14; 
	static private final int SIN_MASK = ~(-1 << SIN_BITS);
	static private final int SIN_COUNT = SIN_MASK + 1;

	static private final float radFull = PI * 2;
	static private final float degFull = 360;
	static private final float radToIndex = SIN_COUNT / radFull;
	static private final float degToIndex = SIN_COUNT / degFull;

	
	static public final float radiansToDegrees = 180f / PI;
	static public final float radDeg = radiansToDegrees;
	
	static public final float degreesToRadians = PI / 180;
	static public final float degRad = degreesToRadians;

	static private class Sin {
		static final float[] table = new float[SIN_COUNT];
		static {
			for (int i = 0; i < SIN_COUNT; i++)
				table[i] = (float)Math.sin((i + 0.5f) / SIN_COUNT * radFull);
			for (int i = 0; i < 360; i += 90)
				table[(int)(i * degToIndex) & SIN_MASK] = (float)Math.sin(i * degreesToRadians);
		}
	}

	
	static public final float sin (float radians) {
		return Sin.table[(int)(radians * radToIndex) & SIN_MASK];
	}

	
	static public final float cos (float radians) {
		return Sin.table[(int)((radians + PI / 2) * radToIndex) & SIN_MASK];
	}

	
	static public final float sinDeg (float degrees) {
		return Sin.table[(int)(degrees * degToIndex) & SIN_MASK];
	}

	
	static public final float cosDeg (float degrees) {
		return Sin.table[(int)((degrees + 90) * degToIndex) & SIN_MASK];
	}


	static private final int ATAN2_BITS = 7; 
	static private final int ATAN2_BITS2 = ATAN2_BITS << 1;
	static private final int ATAN2_MASK = ~(-1 << ATAN2_BITS2);
	static private final int ATAN2_COUNT = ATAN2_MASK + 1;
	static final int ATAN2_DIM = (int)Math.sqrt(ATAN2_COUNT);
	static private final float INV_ATAN2_DIM_MINUS_1 = 1.0f / (ATAN2_DIM - 1);

	static private class Atan2 {
		static final float[] table = new float[ATAN2_COUNT];
		static {
			for (int i = 0; i < ATAN2_DIM; i++) {
				for (int j = 0; j < ATAN2_DIM; j++) {
					float x0 = (float)i / ATAN2_DIM;
					float y0 = (float)j / ATAN2_DIM;
					table[j * ATAN2_DIM + i] = (float)Math.atan2(y0, x0);
				}
			}
		}
	}

	
	static public final float atan2 (float y, float x) {
		float add, mul;
		if (x < 0) {
			if (y < 0) {
				y = -y;
				mul = 1;
			} else
				mul = -1;
			x = -x;
			add = -PI;
		} else {
			if (y < 0) {
				y = -y;
				mul = -1;
			} else
				mul = 1;
			add = 0;
		}
		float invDiv = 1 / ((x < y ? y : x) * INV_ATAN2_DIM_MINUS_1);

		if (invDiv == Float.POSITIVE_INFINITY) return ((float)Math.atan2(y, x) + add) * mul;

		int xi = (int)(x * invDiv);
		int yi = (int)(y * invDiv);
		return (Atan2.table[yi * ATAN2_DIM + xi] + add) * mul;
	}


	static public Random random = new Random();

	
	static public final int random (int range) {
		return random.nextInt(range + 1);
	}

	
	static public final int random (int start, int end) {
		return start + random.nextInt(end - start + 1);
	}

	
	static public final boolean randomBoolean () {
		return random.nextBoolean();
	}

	
	static public final boolean randomBoolean (float chance) {
		return MathUtils.random() < chance;
	}

	
	static public final float random () {
		return random.nextFloat();
	}

	
	static public final float random (float range) {
		return random.nextFloat() * range;
	}

	
	static public final float random (float start, float end) {
		return start + random.nextFloat() * (end - start);
	}


	
	static public int nextPowerOfTwo (int value) {
		if (value == 0) return 1;
		value--;
		value |= value >> 1;
		value |= value >> 2;
		value |= value >> 4;
		value |= value >> 8;
		value |= value >> 16;
		return value + 1;
	}

	static public boolean isPowerOfTwo (int value) {
		return value != 0 && (value & value - 1) == 0;
	}


	static public int clamp (int value, int min, int max) {
		if (value < min) return min;
		if (value > max) return max;
		return value;
	}

	static public short clamp (short value, short min, short max) {
		if (value < min) return min;
		if (value > max) return max;
		return value;
	}

	static public float clamp (float value, float min, float max) {
		if (value < min) return min;
		if (value > max) return max;
		return value;
	}


	static private final int BIG_ENOUGH_INT = 16 * 1024;
	static private final double BIG_ENOUGH_FLOOR = BIG_ENOUGH_INT;
	static private final double CEIL = 0.9999999;
	static private final double BIG_ENOUGH_CEIL = 16384.999999999996;
	static private final double BIG_ENOUGH_ROUND = BIG_ENOUGH_INT + 0.5f;


	static public int floor (float x) {
		return (int)(x + BIG_ENOUGH_FLOOR) - BIG_ENOUGH_INT;
	}


	static public int floorPositive (float x) {
		return (int)x;
	}


	static public int ceil (float x) {
		return (int)(x + BIG_ENOUGH_CEIL) - BIG_ENOUGH_INT;
	}


	static public int ceilPositive (float x) {
		return (int)(x + CEIL);
	}


	static public int round (float x) {
		return (int)(x + BIG_ENOUGH_ROUND) - BIG_ENOUGH_INT;
	}

	
	static public int roundPositive (float x) {
		return (int)(x + 0.5f);
	}

	
	static public boolean isZero (float value) {
		return Math.abs(value) <= FLOAT_ROUNDING_ERROR;
	}


	static public boolean isZero (float value, float tolerance) {
		return Math.abs(value) <= tolerance;
	}


	static public boolean isEqual (float a, float b) {
		return Math.abs(a - b) <= FLOAT_ROUNDING_ERROR;
	}


	static public boolean isEqual (float a, float b, float tolerance) {
		return Math.abs(a - b) <= tolerance;
	}
}