package io.github.mpetruska.ukmodulo.nonstandard

import io.github.mpetruska.ukmodulo.digits.AccountDigits
import org.scalatest.{Matchers, WordSpec}

class TenDigitSpec extends WordSpec with Matchers {

  val expected = AccountDigits(Vector.fill(6)(0) ++ (1 to 8).toVector)

  "TenDigit" should {

    "parse National Westminster account numbers correctly" in {
      TenDigit.parseNationalWestminsterAccountNumber("000000", "0012345678") shouldBe Right(expected)
      TenDigit.parseNationalWestminsterAccountNumber("000000", "00-12345678") shouldBe Right(expected)
      TenDigit.parseNationalWestminsterAccountNumber("000000", "00-123456") shouldBe Left(TenDigit.nationalWestMinsterError)
    }

    "parse Co-Operative account numbers correctly" in {
      TenDigit.parseCoOperativeAccountNumber("000000", "1234567890") shouldBe Right(expected)
      TenDigit.parseCoOperativeAccountNumber("000000", "aaa123456890") shouldBe Left(TenDigit.coOperativeError)
    }

  }

}
