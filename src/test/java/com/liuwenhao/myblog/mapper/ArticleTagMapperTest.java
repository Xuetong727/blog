package com.liuwenhao.myblog.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ArticleTagMapperTest {

    @Mock
    private ArticleTagMapper articleTagMapper;

    @BeforeEach
    public void setUp() {
        // This method will be called before each test method
    }

    @Test
    public void testSelectHotIdsWhenLimitIs5ThenReturnList() {
        // Arrange
        List<Long> expectedList = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        when(articleTagMapper.selectHotIds(5)).thenReturn(expectedList);

        // Act
        List<Long> actualList = articleTagMapper.selectHotIds(5);

        // Assert
        assertThat(actualList).isEqualTo(expectedList);
    }

    @Test
    public void testSelectHotIdsWhenLimitIs10ThenReturnList() {
        // Arrange
        List<Long> expectedList = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L);
        when(articleTagMapper.selectHotIds(10)).thenReturn(expectedList);

        // Act
        List<Long> actualList = articleTagMapper.selectHotIds(10);

        // Assert
        assertThat(actualList).isEqualTo(expectedList);
    }

    @Test
    public void testSelectHotIdsWhenLimitIs0ThenReturnEmptyList() {
        // Arrange
        List<Long> expectedList = Collections.emptyList();
        when(articleTagMapper.selectHotIds(0)).thenReturn(expectedList);

        // Act
        List<Long> actualList = articleTagMapper.selectHotIds(0);

        // Assert
        assertThat(actualList).isEqualTo(expectedList);
    }
}